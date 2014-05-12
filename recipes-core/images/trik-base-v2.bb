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
		packagegroup-firmware \
		packagegroup-utils \
		packagegroup-multimedia \
		udev-extraconf \
		mspbsl \
		mono \
		rc-local \
		python \
		python-pip \
		trik-runtime \
		roslaunch \
		ruby \
		dsp-modules \
		softap-udhcpd-config \
		trik-network \
		"
#packagegroup-core-full-cmdline-sys-services
#packagegroup-core-full-cmdline-multiuser
#packagegroup-core-full-cmdline-extended
#packagegroup-core-full-cmdline-utils
IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE = "1048576"

# remove not needed ipkg informations
#ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; "


