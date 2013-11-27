DESCRIPTION = "rc.local scripts"
LICENSE = "APACHE"
LIC_FILES_CHKSUM = "file://LICENSE;md5=77a4892df63d2a51b015b46a07528112"

SRC_URI = "file://rc.local.etc \
           file://rc.local.init \
           file://LICENSE"

S = "${WORKDIR}"

inherit update-rc.d

INITSCRIPT_NAME = "rc.local"
INITSCRIPT_PARAMS = "start 99 2 3 4 5 ."

do_install () {
    install -d ${D}/${sysconfdir}/init.d
    install -m 755 ${S}/rc.local.etc ${D}/${sysconfdir}/rc.local
    install -m 755 ${S}/rc.local.init ${D}/${sysconfdir}/init.d/rc.local

}
