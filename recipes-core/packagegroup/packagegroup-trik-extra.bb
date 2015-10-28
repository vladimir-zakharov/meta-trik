SUMMARY = "Utils"
DESCRIPTION = "The minimal set of packages required to manupulate usb, i2c,input devices,ext2FS"
LICENSE = "LGPL"
PR = "r0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup


MACHINE_ESSENTIAL_EXTRA_RDEPENDS ?= ""
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS ?= ""

RDEPENDS_${PN} = "\
  atop \
  ${MACHINE_ESSENTIAL_EXTRA_RDEPENDS} \
 "

RRECOMMENDS_${PN} = "\
  ${MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS} \
 "

