inherit image_types
IMAGE_TYPES += "trik-img"

IMAGE_TYPEDEP_trik-img = "ext4"
IMAGE_ROOTFS_ALIGNMENT ?= "4096"
EXTRA_IMAGECMD_ext4_prepend = "-E stride=2 -E stripe-width=64 -b 4096 -i 4096 "

TRIKIMG_ROOTFS =  "${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ext4"

#IMAGE_DEPENDS_trik-img = " \
#                        parted-native \
#                        mtools-native \
#                        dosfstools-native \
#                        virtual/kernel \
#                        "

TRIKIMG = "${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.trik-img"

IMAGE_CMD_trik-img () {
	ROOTFS_SIZE=`du --dereference --apparent-size --block-size=1K --summarize ${TRIKIMG_ROOTFS} | cut -f 1`
	
        TRIKIMG_SIZE_ALIGNED_CNT=`expr \( ${ROOTFS_SIZE} + ${IMAGE_ROOTFS_ALIGNMENT} - 1 \) / ${IMAGE_ROOTFS_ALIGNMENT}`
        # sparse file with 1 additional block for partition table 	
	dd if=/dev/zero of=${TRIKIMG} bs=${IMAGE_ROOTFS_ALIGNMENT}K seek=${TRIKIMG_SIZE_ALIGNED_CNT} count=1
	parted -s ${TRIKIMG} -- unit KiB mklabel msdos mkpart primary ext4 ${IMAGE_ROOTFS_ALIGNMENT} -1s set 1 hidden on print
	dd if=${TRIKIMG_ROOTFS} of=${TRIKIMG} conv=fsync bs=${IMAGE_ROOTFS_ALIGNMENT}K seek=1 
}

