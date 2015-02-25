
IMAGE_ROOTFS_ALIGNMENT ?= "4096"
IMAGE_ROOTFS_SIZE ?= "1572864"
XZ_COMPRESSION_LEVEL ?= " -6 --armthumb --lzma2 "
EXTRA_IMAGECMD_ext4 =+ " -E stride=2 -E stripe-width=16 -b 4096 -i 4096 "

inherit image_types

IMAGE_TYPES += "ext4 ext4.xz sdimg sdimg.xz"
IMAGE_TYPEDEP_sdimg = "ext4"
IMAGE_TYPEDEP_sdimg.xz = "sdimg"

IMAGE_DEPENDS_sdimg = 	"\
			parted-native \
			e2fsprogs-native \
			"

IMAGE_FSTYPES_append = "sdimg.xz sdimg"

#IMAGE_TYPES_MASKED = "sdimg"

EXCLUDE_FROM_WORLD = "1"

##inherit image-mklibs
inherit image-prelink


TRIKIMG_ROOTFS =  "${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ext4"

TRIKIMG_FILE ?= "${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.sdimg"

#reserve space for FAT partition
# NOT SUPPORTED YET!!!
# NOW IT IS CREATED WITH SIZE OF IMAGE_ROOTFS_ALIGNMENT KiBs 
TRIKIMG_FAT_SIZE ?= "${IMAGE_ROOTFS_ALIGNMENT}"

IMAGE_CMD_sdimg () { 
        create_trik_sd_image
}

create_trik_sd_image (){
	ROOTFS_SIZE=`du --dereference --apparent-size --block-size=1K --summarize ${TRIKIMG_ROOTFS} | cut -f 1`

        # reserve room for rootfs  	
	truncate "-s >${ROOTFS_SIZE}K" ${TRIKIMG_FILE}  
	
	#round upto alignment
	truncate "-s %${IMAGE_ROOTFS_ALIGNMENT}K" ${TRIKIMG_FILE}  

	# reserve space for FAT partition
	truncate "-s +${TRIKIMG_FAT_SIZE}K" ${TRIKIMG_FILE}  

        #round to alignment again
	truncate "-s %${IMAGE_ROOTFS_ALIGNMENT}K" ${TRIKIMG_FILE}  

	parted -s ${TRIKIMG_FILE} -- \
           unit KiB \
           mklabel msdos \
           mkpart primary ext4 ${IMAGE_ROOTFS_ALIGNMENT} -1s \
           set 1 hidden on \
           mkpart primary fat32 1 ${IMAGE_ROOTFS_ALIGNMENT} \
           print
	
        dd if=${TRIKIMG_ROOTFS} of=${TRIKIMG_FILE} conv=fsync bs=${IMAGE_ROOTFS_ALIGNMENT}K seek=1 
}


python do_sdimg() {
        bb.build.exec_func('create_trik_sd_image', d)
}


#do_fetch[noexec] = "1"
#do_unpack[noexec] = "1"
#do_patch[noexec] = "1"
#do_configure[noexec] = "1"
#do_compile[noexec] = "1"
#do_install[noexec] = "1"
#do_populate_sysroot[noexec] = "1"
#do_package[noexec] = "1"
#do_packagedata[noexec] = "1"
#do_package_write_ipk[noexec] = "1"
#do_package_write_deb[noexec] = "1"
#do_package_write_rpm[noexec] = "1"

do_sdimg[depends] += "parted-native:do_populate_sysroot ${PN}:do_rootfs"

#addtask sdimg after do_rootfs

