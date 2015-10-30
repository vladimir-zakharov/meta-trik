DECRIPTION = "Runtime for TRIK controller"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"
RDEPENDS_${PN} = "locale-default espeak alsa-utils"
RRECOMMENDS_${PN} = "vlc"

inherit qt4e user-partion

BRANCH  = "master"
SRCREV	= "${AUTOREV}"
SRC_URI = "git://github.com/trikset/trikRuntime.git;branch=${BRANCH} \
	  file://qws_display.sh \
	  file://trikGui.runner"

S = "${WORKDIR}/git"

do_compile(){
        export CROSS_COMPILE="${TARGET_PREFIX}"
        oe_runmake
}

do_install() {
        oe_runmake INSTALL_ROOT=${D}/ install
	install -d ${D}/${TRIK_USER_PARTION_CREATION_DIR}/scripts ${D}/home/root/
	ln -s ${TRIK_USER_PARTION_CREATION_DIR}/scripts ${D}/home/root/scripts

        install -d ${D}/${sysconfdir}/profile.d/
        install -m 0755 ${WORKDIR}/qws_display.sh ${D}/${sysconfdir}/profile.d/

	install -d ${D}/${sysconfdir}/trik/
	install -m 0755 ${WORKDIR}/trikGui.runner ${D}/${sysconfdir}/trik/trikGui.sh

}
FILES_${PN} += "${TRIK_USER_PARTION_CREATION_DIR}/scripts \
		/home/root/ \
		${sysconfdir} \
		/usr/share/"

pkg_postinst_${PN} () {
        killall trikGui || true
        sleep 3
        killall -9 trikGui 2> /dev/null || true
}

