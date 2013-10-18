DESCRIPTION = "Runtime for TRIK controller"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"


PR = "r4"

PROVIDES="trik-runtime"

S = "${WORKDIR}/git"
BRANCH = "mrv_buildsystem"
SRCREV = "${AUTOREV}"

SRC_URI = "git://github.com/trikset/trikRuntime.git;branch=${BRANCH}"

do_install() {
	oe_runmake INSTALL_ROOT=${D}/home/root/trik/ install
	install -m 0755 ${S}/trikRun/test.qts ${D}/home/root/trik/
	install -m 0755 ${S}/media/beep.mp3 ${D}/home/root/trik/
	install -m 0755 ${S}/trikControl/config.xml ${D}/home/root/trik/
}
FILES_${PN} = "/home/root/trik/"
FILES_${PN}-dev += "/home/root/trik/*.so"
FILES_${PN}-dbg += "/home/root/trik/.debug"
inherit qt4e
