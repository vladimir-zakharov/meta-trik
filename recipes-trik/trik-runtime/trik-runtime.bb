DESCRIPTION = "Runtime for TRIK controller"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"


PR = "r1"

S = "${WORKDIR}/git"
BRANCH = "master"
#SRCREV = "${AUTOREV}"
SRCREV = "a1802c43d053957b3e32f8de99ee8b0b791b64f2"

SRC_URI = "git://github.com/trikset/trikRuntime.git;branch=${BRANCH}"

do_install() {
        oe_runmake INSTALL_ROOT=${D}/${prefix} install
}

inherit qt4e
