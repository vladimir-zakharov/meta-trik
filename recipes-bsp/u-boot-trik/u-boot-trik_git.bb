include ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

SECTION= "bootloader"

PROVIDES = "virtual/bootloader"

LICENSE = "GPLv2+"

COMPATIBLE_MACHINE = "trikboard"

PACKAGE_ARCH = "${MACHINE_ARCH}"
BRANCH = "trik-u-boot-2013.01.y"
SRCREV = "${AUTOREV}"
SRC_URI_trikboard = "git://github.com/trikset/trik-u-boot.git;branch=${BRANCH}"

#trikboard_config
#aisimage
#u-boot-gzip.ais

LIC_FILES_CHKSUM="file://COPYING;beginline=1;endline=306;md5=1707d6db1d42237583f50183a5651ecb"

S = "${WORKDIR}/git"

UBOOT_MACHINE = "trikboard_config"

BBCLASSEXTEND = "native nativesdk"

