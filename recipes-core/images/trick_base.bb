DESCRIPTION = "Trick Base Image"

include recipes-core/images/core-image-minimal.bb

# Include modules in rootfs
IMAGE_INSTALL += " \
        kernel-modules \
        usbutils \
        i2c-tools \
        alsa-utils \
        devmem2 \
        evtest \
        "
IMAGE_DEV_MANAGER   = "udev"
IMAGE_INIT_MANAGER  = "systemd"
IMAGE_INITSCRIPTS   = " "
IMAGE_LOGIN_MANAGER = "tinylogin shadow"

export IMAGE_BASENAME = "trick-base-image"
