SUMMARY = "Utils"
DESCRIPTION = "The minimal set of packages required to manupulate usb, i2c,input devices,ext2FS"
LICENSE = "LGPL"
PR = "r0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup


MACHINE_ESSENTIAL_EXTRA_RDEPENDS ?= ""
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS ?= ""

RDEPENDS_${PN} = "\
  iptables \
  mtd-utils \
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
  tzdata \
  rsync \
  fbgrab \
  u-boot-trik-fw-utils \
  wget \
  psplash \
  picocom \
  usb-modeswitch \
  usb-modeswitch-data \
  rp-pppoe \
  samba \
  winbind \
  bash-completion \
  ${MACHINE_ESSENTIAL_EXTRA_RDEPENDS} \
 "

RRECOMMENDS_${PN} = "\
  ${MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS} \
 "

