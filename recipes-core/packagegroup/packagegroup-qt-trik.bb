SUMMARY = "Qt for Embedded Linux (Qt with X11)"
PR = "r2"
LICENSE = "MIT"

# Qt4 could NOT be built on MIPS64 with 64 bits userspace
COMPATIBLE_HOST_mips64 = "null"

inherit packagegroup

TOUCH = ' ${@bb.utils.contains("MACHINE_FEATURES", "touchscreen", "tslib tslib-calibrate tslib-tests", "",d)}'
RDEPENDS_${PN} = " \
	qt4 \
"

RRECOMMENDS_${PN} = " \
"
