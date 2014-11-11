DESCRIPTION = "Software for various robots built using TRIK (http://www.trikset.com/) constructor"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=19cbd64715b51267a47bf3750cc6a8a5"
RDEPENDS_${PN} = "trik-runtime"
BRANCH  = "master"
SRCREV  = "${AUTOREV}"
SRC_URI = "git://github.com/trikset/trik-models.git;branch=${BRANCH}"

S = "${WORKDIR}/git"

do_compile(){
	  bbnote "Empty do_compile task"
}
do_install(){
	rm -rf ${D}/home/root/trik/scripts/demos/
	install -d ${D}/home/root/trik/scripts/demos/
	install -m 0755 ${S}/*.qts ${D}/home/root/trik/scripts/demos/
	
	install -d ${D}/home/root/trik/scripts/demos/r2d2/
	install -m 0755 ${S}/r2d2/*.qts ${D}/home/root/trik/scripts/demos/r2d2/
	install -d ${D}/home/root/trik/scripts/demos/virtualMouse/
	install -m 0755 ${S}/virtualMouse/*.qts  ${D}/home/root/trik/scripts/demos/virtualMouse/
}
FILES_${PN} = "/home/root/trik/scripts/"
