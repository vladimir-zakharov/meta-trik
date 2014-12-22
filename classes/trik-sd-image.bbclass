inherit image_types
IMAGE_TYPES += "trik-img"

IMAGE_TYPEDEP_trik-img = "ext4"
IMAGE_ROOTFS_ALIGNMENT = "4096"
TRIKIMG_ROOTFS =  "${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ext4"

IMAGE_DEPENDS_trik-img = " \
                        parted-native \
                        mtools-native \
                        dosfstools-native \
                        virtual/kernel \
                        "

TRIKIMG = "${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.trik-img"

IMAGE_CMD_trik-img () {
	ROOTFS_SIZE=`du -bks ${TRIKIMG_ROOTFS} | awk '{print $1}'`
	ROOTFS_SIZE_ALIGNED=$(expr ${ROOTFS_SIZE} + ${IMAGE_ROOTFS_ALIGNMENT} - 1)
        ROOTFS_SIZE_ALIGNED=$(expr ${ROOTFS_SIZE_ALIGNED} - ${ROOTFS_SIZE_ALIGNED} % ${IMAGE_ROOTFS_ALIGNMENT})
	TRIKIMG_SIZE=$(expr ${IMAGE_ROOTFS_ALIGNMENT} + ${ROOTFS_SIZE_ALIGNED})
	dd if=/dev/zero of=${TRIKIMG} bs=1024 count=0 seek=${TRIKIMG_SIZE}
	
	parted -s ${TRIKIMG} mklabel msdos
	parted -s ${TRIKIMG} -- unit KiB mkpart primary ext4 ${IMAGE_ROOTFS_ALIGNMENT} -1s
	parted ${TRIKIMG} print

	dd if=${TRIKIMG_ROOTFS} of=${TRIKIMG} conv=notrunc seek=1 bs=$(expr ${IMAGE_ROOTFS_ALIGNMENT} \* 1024) && sync && sync

}

