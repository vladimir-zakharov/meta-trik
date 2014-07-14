SUMMARY = "MJPG-streamer takes JPGs from Linux-UVC compatible webcams, filesystem or other input plugins and streams \
           them as M-JPEG via HTTP to webbrowsers, VLC and other software"
HOMEPAGE = "http://sourceforge.net/projects/mjpg-streamer/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"
SRCREV = "182"
MODULE="mjpg-streamer"
SRC_URI = "svn://svn.code.sf.net/p/mjpg-streamer/code;module=${MODULE};rev=${SRCREV}\
	   file://cross_compile_fix.patch"

S ="${WORKDIR}/${MODULE}"
do_compile() {
	oe_runmake all
}
do_install() {
	install --mode=755 -d ${D}/usr/lib/
	install --mode=755 -d ${D}/usr/bin/
	install --mode=755 -d ${D}/www
	install --mode=644 -D ${S}/www/* ${D}/www/
	install --mode=755  ${S}/mjpg_streamer ${D}/usr/bin/
	install --mode=755  ${S}/*.so ${D}/usr/lib/
	

}
FILES_${PN} += "/usr/lib/*"
FILES_${PN} += "/www/*"
