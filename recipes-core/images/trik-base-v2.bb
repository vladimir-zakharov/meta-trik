PR="r5"
DESCRIPTION = "Trik-base v2"

IMAGE_INSTALL = "packagegroup-base \
		packagegroup-core-boot \
		${ROOTFS_PKGMANAGE_BOOTSTRAP} \
		${CORE_IMAGE_EXTRA_INSTALL} \
		packagegroup-wifi \
		packagegroup-qte-trik \
		packagegroup-core-ssh-openssh \
		packagegroup-firmware \
		packagegroup-utils \
		packagegroup-multimedia \
		opkg \
		udev-extraconf \
		mspbsl \
		mono \
  "

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE = "131072"

# remove not needed ipkg informations
ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; "


