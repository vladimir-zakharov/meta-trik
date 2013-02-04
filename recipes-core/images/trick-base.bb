DESCRIPTION = "Trick Base Image"

include recipes-core/images/core-image-minimal.bb

IMAGE_FEATURES += "qt4-embedded ssh-server-dropbear"

LICENSE = "MIT"

inherit core-image
#256MB
IMAGE_ROOTFS_SIZE = "262144"

# Include modules in rootfs
IMAGE_INSTALL += " \
        kernel-modules \
	linux-firmware \
	qt4-embedded \
	copter-pwm-ctrl-qt \
        usbutils \
	alsa-utils \
	evtest \
	i2c-tools \
	avahi \
	bluez4 \
	wpa-supplicant \
	wireless-tools \
        "
