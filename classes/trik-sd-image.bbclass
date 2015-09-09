
IMAGE_ROOTFS_ALIGNMENT ?= "4096"

XZ_COMPRESSION_LEVEL ?= " -6 --armthumb --lzma2 "
EXTRA_IMAGECMD_ext4 =+ " -E stride=2 -E stripe-width=16 -b 4096 -i 4096 "

inherit image_types

IMAGE_TYPES += "ext4 ext4.xz sdimg sdimg.xz"
IMAGE_TYPEDEP_sdimg = "ext4"
IMAGE_TYPEDEP_sdimg.xz = "sdimg"

IMAGE_DEPENDS_sdimg = 	"\
			parted-native \
			e2fsprogs-native \
			dosfstools-native \
			mtools-native \
			"

IMAGE_FSTYPES_append = "sdimg.xz sdimg"

#IMAGE_TYPES_MASKED = "sdimg"

EXCLUDE_FROM_WORLD = "1"

##inherit image-mklibs
inherit image-prelink

TRIKIMG_CONF_PARTION_INSTALL ?= "0"
TRIKIMG_CONF_PARTION_INSTALL_DIR ?= ""
TRIKIMG_CONF_PARTION = "${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.conf.vfat"
TRIKIMG_CONF_PARTION_LABEL = "trik-configs"
TRIKIMG_CONFFS_SIZE ?= "102400" 


TRIKIMG_ROOTFS =  "${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ext4"
TRIKIMG_FILE ?= "${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.sdimg"

IMAGE_CMD_sdimg () {
	#if [${TRIKIMG_CONF_PARTION_INSTALL} != "0"]; then
		create_trik_conf_image
	#fi
        create_trik_sd_image
}
# temporary add timestamp into conffs 
IMAGEDATESTAMP = "${@time.strftime('%Y.%m.%d',time.gmtime())}"

create_trik_conf_image () {
	echo "We are create_trik_conf_image"
	rm -rf ${TRIKIMG_CONF_PARTION}
	truncate "-s >${TRIKIMG_CONFFS_SIZE}K" ${TRIKIMG_CONF_PARTION}
	mkdosfs -F 32 -n ${TRIKIMG_CONF_PARTION_LABEL} ${TRIKIMG_CONF_PARTION}

	echo "${IMAGE_NAME}-${IMAGEDATESTAMP}" > ${WORKDIR}/image-version-info

	mcopy -i ${TRIKIMG_CONF_PARTION} -v ${WORKDIR}//image-version-info ::/
	mcopy -i ${TRIKIMG_CONF_PARTION} -s ${TRIKIMG_CONF_PARTION_INSTALL_DIR}/* ::/

}


create_trik_sd_image (){
	echo "We are create_trik_sd_image" 
	ROOTFS_SIZE=`du --dereference --apparent-size --block-size=1K --summarize ${TRIKIMG_ROOTFS} | cut -f 1`
	# TODO : check size of images 

        # reserve room for rootfs  	
	truncate "-s >${ROOTFS_SIZE}K" ${TRIKIMG_FILE}  
	
	# #round upto alignment
	truncate "-s %${IMAGE_ROOTFS_ALIGNMENT}K" ${TRIKIMG_FILE}  

	# # reserve space for FAT partition
	truncate "-s +${TRIKIMG_CONFFS_SIZE}K" ${TRIKIMG_FILE}  

 #        #round to alignment again
	truncate "-s %${IMAGE_ROOTFS_ALIGNMENT}K" ${TRIKIMG_FILE}  



	parted -s ${TRIKIMG_FILE} -- \
           unit KiB \
           mklabel msdos \
           mkpart primary ext4 ${TRIKIMG_CONFFS_SIZE} -1s \
           set 1 hidden on \
           mkpart primary fat32 1 ${TRIKIMG_CONFFS_SIZE} \
           print

    dd if=${TRIKIMG_CONF_PARTION} of=${TRIKIMG_FILE} conv=fsync bs=1K seek=1

    dd if=${TRIKIMG_ROOTFS} of=${TRIKIMG_FILE} conv=fsync bs=${TRIKIMG_CONFFS_SIZE}K seek=1
}


python do_sdimg() {
		zz
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

