DESCRIPTION = "Trick Base Image"

include recipes-core/images/core-image-minimal.bb

IMAGE_FEATURES += "qt4e"

LICENSE = "MIT"

inherit core-image

# Include modules in rootfs
IMAGE_INSTALL += " \
        kernel-modules \
        usbutils \
        i2c-tools \
        alsa-utils \
        devmem2 \
        evtest \
        "

export IMAGE_BASENAME = "trick-base-image"
