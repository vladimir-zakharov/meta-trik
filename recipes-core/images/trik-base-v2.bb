PR="r5"
DESCRIPTION = "Trik-base v2"
IMAGE_FEATURES += "package-management"
IMAGE_INSTALL = "packagegroup-base \
		packagegroup-core-boot \
		${ROOTFS_PKGMANAGE_BOOTSTRAP} \
		${CORE_IMAGE_EXTRA_INSTALL} \
		packagegroup-wifi \
		packagegroup-qte-trik \
		packagegroup-core-ssh-openssh \
		localedef \
		packagegroup-firmware \
		packagegroup-utils \
		packagegroup-multimedia \
		packagegroup-core-tools-debug \
		udev-extraconf \
		mspbsl \
		mono \
		fsharp \
		rc-local \
		python \
		python-pip \
		trik-runtime \
		ruby \
		dsp-modules \
		softap-udhcpd-config \
		trik-network \
		fuse \
		eglibc-utils \
		locale-base-ru-ru \
		locale-default \
"

IMAGE_LINGUAS = "en-us ru-ru"

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE = "1572864"

# remove not needed ipkg informations
#ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; "


