SUMMARY = "Atop is an ASCII full-screen performance monitor."
DESCRIPTION = "At regular intervals, it shows system-level activity \
related to the CPU, memory, swap, disks and network layers, and \
for every process (and thread) it shows a.o. the CPU utilization, \
memory growth, disk utilization, priority, username, state, and exit code."
HOMEPAGE = "http://www.atoptool.nl"
LICENSE = "GPLv2"
DEPENDS = "ncurses"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI = "http://www.atoptool.nl/download/${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "f1dd1984584f9635712cb7196e25620c"
SRC_URI[sha256sum] = "a620dbe0de7c7ee004949b201bed27559a8dd6cbdee651c7a3e15fc584723409"

INITSCRIPT_NAME = "${PN}"
INITSCRIPT_PARAMS = "defaults"

do_compile(){
	oe_runmake 
}
do_install(){
        oe_runmake 'DESTDIR=${D}' install
}

inherit  update-rc.d

