SUMMARY = "SocketCAN Driver for USB-CANmodul series"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"
inherit module

PR= "r0"
PV= "0.9.0"

SRC_URI = "http://www.systec-electronic.com/uploads/a1/eb/a1eb3bb3232527f5019eda310f3aa7ec/systec_can-V${PV}.tar.bz2 \
	   file://Makefile_fix.patch"
SRC_URI[md5sum] = "11a07cd63f157533556499a9e9aca427"

S= "${WORKDIR}/systec_can/"
module_do_install_append(){
	oe_runmake  INSTALL_MOD_PATH="${D}" firmware_install
}
PACKAGES += "linux-firmware-${PN}"

FILES_linux-firmware-${PN} = "/lib/firmware/*.fw"
