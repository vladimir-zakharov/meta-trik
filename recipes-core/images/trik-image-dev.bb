PR="r0"
DESCRIPTION = "TRIK image dev"

IMAGE_FEATURES += "package-management splash x11-base ssh-server-dropbear"
IMAGE_INSTALL = "packagegroup-base \
		packagegroup-core-boot \
		${ROOTFS_PKGMANAGE_BOOTSTRAP} \
		${CORE_IMAGE_EXTRA_INSTALL} \
		packagegroup-core-tools-debug \
		packagegroup-core-tools-profile \
		packagegroup-wifi \
		packagegroup-firmware \
		packagegroup-multimedia \
		packagegroup-fonts-truetype \
		icu \
		qt4-x11-free \
		fotowall \
		trik-runtime \
"
# networking(wifi,bluez,3g)
# graphics (X11,qt4)
#multimedia ()
# languages
# dsp trik
# core-tools

IMAGE_LINGUAS = "en-us ru-ru"

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE = "1572864"

# remove not needed ipkg informations
#ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; "


