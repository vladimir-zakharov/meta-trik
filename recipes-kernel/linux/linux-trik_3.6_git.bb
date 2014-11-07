SECTION = "Kernel"
DESCRIPTION = "Linux Kernel for DaVinci Trik linux"
LICENSE = "GPLv2"
KERNEL_IMAGETYPE = "uImage"
KERNEL_VERSION ="3.6.7"

PR = "r2"

inherit kernel

KERNEL_MODULE_AUTOLOAD +="l3g42xxd"
KERNEL_MODULE_AUTOLOAD +="l3g42xxd_spi"

MULTI_CONFIG_BASE_SUFFIX = ""

SRCREV = "${AUTOREV}"
BRANCH = "trik-linux-3.6.7-release-2014-11-05"
SRC_URI = "git://github.com/trikset/trik-linux.git;branch=${BRANCH} \
	   file://defconfig"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://COPYING;beginline=1;endline=355;md5=bad9197b13faffd10dfc69bd78fd072e"

