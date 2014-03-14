SUMMARY = "Utils"
DESCRIPTION = "The minimal set of packages required to manupulate usb, i2c,input devices,ext2FS"
LICENSE = "LGPL"
PR = "r0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS ?= ""
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS ?= ""

RDEPENDS_${PN} = "\
  iptables \
  evtest \
  i2c-tools \
  usbutils \
  e2fsprogs \
  mc \
  lrzsz \
  ntp \
  strace \
  ltrace \
  atop \
  cronie \
  ${MACHINE_ESSENTIAL_EXTRA_RDEPENDS} \
 "

RRECOMMENDS_${PN} = "\
  ${MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS} \
 "

