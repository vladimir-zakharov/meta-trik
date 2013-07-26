SUMMARY = "Firmware package"
DESCRIPTION = "Firmware for usb-wifi(ath9k,rt73),wl12xx,bluetooth"
LICENSE = "LGPL"
PR = "r1"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS ?= ""
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS ?= ""

RDEPENDS_${PN} = "\
  linux-firmware-wl12xx \
  linux-firmware-ath9k \
  linux-firmware-ralink \
  ${MACHINE_ESSENTIAL_EXTRA_RDEPENDS} \
 "

RRECOMMENDS_${PN} = "\
  ${MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS} \
 "

