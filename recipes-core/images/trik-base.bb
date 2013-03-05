DESCRIPTION = "Trick Base Image"

IMAGE_INSTALL = "packagegroup-core-boot \
	packagegroup-core-ssh-openssh \
	packagegroup-core-qt4e \
	${ROOTFS_PKGMANAGE_BOOTSTRAP} \
	${CORE_IMAGE_EXTRA_INSTALL} \
        kernel-modules \
	packagegroup-ti-drivers \
        usbutils \
        alsa-utils \
        evtest \
        i2c-tools \
        avahi \
        bluez4 \
        wpa-supplicant \
        wireless-tools \
	"
#	ti-dsplink \
#	"
#        copter-pwm-ctrl-qt \
#        "

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE = "262144"

# remove not needed ipkg informations
ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; "
