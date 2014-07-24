DESCRIPTION = "Runtime for TRIK controller"
PROVIDES="trik-runtime"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

inherit qt4e update-rc.d

PR = "r4"

S = "${WORKDIR}/git"
TAG = "v3.0.0-a8"

SRC_URI = "git://github.com/trikset/trikRuntime.git;tag=${TAG} \
	  file://trikGui.sh"

INITSCRIPT_NAME = "trikGui.sh"
INITSCRIPT_PARAMS = "start 95 2 3 4 5 . stop 95 0 1 6 ."
do_compile(){
	export CROSS_COMPILE="${TARGET_PREFIX}"
	oe_runmake
}
do_install() {
	oe_runmake INSTALL_ROOT=${D}/home/root/trik/ install
	install -m 0755 ${S}/trikRun/test.qts ${D}/home/root/trik/
        install -d -m 0755 ${D}/home/root/trik/media/
	install -m 0755 ${S}/media/* ${D}/home/root/trik/media/
	install -m 0755 ${S}/trikScriptRunner/system.js ${D}/home/root/trik/

	install -m 0755 ${S}/trikControl/config.xml ${D}/home/root/trik/
	install -m 0755 ${S}/trikGui/wpa-config.xml ${D}/home/root/trik/
	install -d ${D}/${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/trikGui.sh ${D}/${sysconfdir}/init.d/
}	


FILES_${PN} = "/home/root/trik/"
FILES_${PN} += "/etc/*"
FILES_${PN}-dev += "/home/root/trik/*.so"
FILES_${PN}-dbg += "/home/root/trik/.debug"

