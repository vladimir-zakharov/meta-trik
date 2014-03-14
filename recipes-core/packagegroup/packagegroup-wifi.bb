SUMMARY = "Wifi tools"
DESCRIPTION = "The minimal set of packages required to manupulate wifi"
LICENSE = "LGPL"
PR = "r0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS ?= ""
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS ?= ""


RDEPENDS_${PN} = "\
  avahi \
  wpa-supplicant \
  wireless-tools \
  hostap-daemon \
  ${MACHINE_ESSENTIAL_EXTRA_RDEPENDS} \
 "
#  ifplugd 

RRECOMMENDS_${PN} = "\
  ${MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS} \
 "

