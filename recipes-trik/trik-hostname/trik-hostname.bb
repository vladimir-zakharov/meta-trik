DECRIPTION = "Generate default hostname "
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

COMPATIBLE_MACHINE = "trikboard"

PR="r0"

S = "${WORKDIR}"

inherit update-rc.d
INITSCRIPT_NAME = "trik-hostname.sh"
INITSCRIPT_PARAMS="start 02 2 3 4 5 ."

SRC_URI = "file://trik-hostname.sh"

do_configure[noexec] = "1"
do_compile[noexec] = ""
do_install() {
	install -d -m 0755 ${D}${sysconfdir}/init.d/
	install -m 0755 ${S}/trik-hostname.sh ${D}${sysconfdir}/init.d/
}

FILES_${PN}= "/"
