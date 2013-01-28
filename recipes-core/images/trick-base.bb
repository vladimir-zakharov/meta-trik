DESCRIPTION = "Trick Base Image"

include recipes-core/images/core-image-minimal.bb

IMAGE_FEATURES += "qt4-embedded ssh-server-dropbear"

LICENSE = "MIT"

inherit core-image

# Include modules in rootfs
IMAGE_INSTALL += " \
	packagegroup-core-qt4e \
        kernel-modules \
        usbutils \
        i2c-tools \
        alsa-utils \
        devmem2 \
        evtest \
        "
