SUMMARY = "MJPG-streamer takes JPGs from Linux-UVC compatible webcams, filesystem or other input plugins and streams \
           them as M-JPEG via HTTP to webbrowsers, VLC and other software"
HOMEPAGE = "https://github.com/dmitry42nd/mjpg-streamer/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"

BRANCH = "trik-master"
SRCREV  = "${AUTOREV}"
SRC_URI = "git://github.com/dmitry42nd/mjpg-streamer.git;protocol=https;branch=${BRANCH} \
	   file://mjpg-streamer-ov7670.sh"
PR = "r0"
DEPENDS = "jpeg"
RDEPENDS_${PN} = "mjpg-encoder-ov7670"

S ="${WORKDIR}/git/mjpg-streamer-experimental"

do_compile() {
        oe_runmake all
}
do_install() {
        oe_runmake DESTDIR="${D}/" install
	install -d ${D}/${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/mjpg-streamer-ov7670.sh ${D}/${sysconfdir}/init.d/
}

FILES_${PN} += "/usr/lib/*"



