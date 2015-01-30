HOMEPAGE = "http://trikset.com"
SECTION = "kernel/userland"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6c4db32a2fa8717faffa1d4f10136f47"
SUMMARY = "Shell scripts and configuration files for managing network on TRIK controller"

inherit update-rc.d
INITSCRIPT_NAME = "trik-network"
INITSCRIPT_PARAMS = "start 94 2 3 4 5 . "

do_configure() {
	bbwarn "Empty"
}
do_compile() {
	bbwarn "Empty" 
}
do_install() {
	install -d -m 755 ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/trik-network.init ${D}${sysconfdir}/init.d/trik-network
	install -d -m 755 ${D}${sysconfdir}/trik/
	install -m 755 ${WORKDIR}/set_wifi_mode.sh ${D}${sysconfdir}/trik/
	install -m 755 ${WORKDIR}/init_wifi.sh ${D}${sysconfdir}/trik/
}
