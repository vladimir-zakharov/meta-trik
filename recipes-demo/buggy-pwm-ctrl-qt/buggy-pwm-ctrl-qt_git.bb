DESCRIPTION = ""
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://README;md5=c586616b17a75cff528ce32452446361"

PR = "r0"

S = "${WORKDIR}/git"

BRANCH = "master"
SRCREV = "${AUTOREV}"

SRC_URI = "git://github.com/EvilTosha/car-demo.git;branch=${BRANCH}"

do_install() {
        oe_runmake INSTALL_ROOT=${D}/${prefix} install
}

inherit qt4e


