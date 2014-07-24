SECTION = "Kernel"
DESCRIPTION = "Linux Kernel for DaVinci Trik linux"
LICENSE = "GPLv2"
KERNEL_IMAGETYPE = "uImage"
KERNEL_VERSION ="3.6.7"

PR = "r1"

inherit kernel

KERNEL_MODULE_AUTOLOAD +="l3g42xxd"
KERNEL_MODULE_AUTOLOAD +="l3g42xxd_spi"

MULTI_CONFIG_BASE_SUFFIX = ""

SRCREV = "1e168c6db8d2804d30d073d9f20c7f5a2e723062"
SRC_URI = "git://github.com/trikset/trik-linux.git;branch=trik-linux-3.6.7-release-2014-07-07 \
	   file://defconfig"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://COPYING;beginline=1;endline=355;md5=bad9197b13faffd10dfc69bd78fd072e"

