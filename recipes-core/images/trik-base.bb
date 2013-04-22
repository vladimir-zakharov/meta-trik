PR = "r4"

DESCRIPTION = "Trik Base Image"

IMAGE_INSTALL = "packagegroup-core-boot \
	packagegroup-core-ssh-openssh \
	packagegroup-core-qt4e \
	${ROOTFS_PKGMANAGE_BOOTSTRAP} \
	${CORE_IMAGE_EXTRA_INSTALL} \
	gstreamer \
	gst-plugins-base \
	gst-plugins-good \
	gst-plugins-bad \
        kernel-modules \
	packagegroup-ti-drivers \
        usbutils \
	avahi \
        wpa-supplicant \
        wireless-tools \
        "

#       alsa-utils \
#        evtest \
#        i2c-tools \
#        bluez4 \
#        wpa-supplicant \
#        wireless-tools \
#	"
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
