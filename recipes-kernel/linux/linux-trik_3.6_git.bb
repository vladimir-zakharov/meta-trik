SECTION = "Kernel"
DESCRIPTION = "Linux Kernel for DaVinci Trik linux"
LICENSE = "GPLv2"
KERNEL_IMAGETYPE = "uImage"
KERNEL_VERSION ="3.6.7"

PR = "r1"

inherit kernel

module_autoload_l3g42xxd="l3g42xxd"
module_autoload_l3g42xxd_spi="l3g42xxd_spi"

MULTI_CONFIG_BASE_SUFFIX = ""

SRCREV = "d5c5758d1749fb74d192318e24384dfa6b863fb2"
SRC_URI = "git://github.com/trikset/trik-linux.git;branch=trik-linux-3.6.7-ov7670 \
	   file://defconfig"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://COPYING;beginline=1;endline=355;md5=bad9197b13faffd10dfc69bd78fd072e"

