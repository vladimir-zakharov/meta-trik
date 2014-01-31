SUMMARY = "Qt for Embedded Trik Linux (Qt without X11)"
PR = "r3"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = " \
	icu \
        libqt-embeddedcore4 \
        libqt-embeddedgui4 \
	libqt-embeddeddbus4 \
        libqt-embeddednetwork4 \
        libqt-embeddedscript4 \
        libqt-embeddedscripttools4 \
	qt4-embedded-fonts-ttf-dejavu \
        qt4-embedded-plugin-imageformat-jpeg \
        qt4-embedded-plugin-imageformat-tiff \
        qt4-embedded-plugin-mousedriver-tslib \
        qt4-embedded-plugin-sqldriver-sqlite \
	tslib \
	tslib-calibrate \
	tslib-tests \
	qt4-embedded-demos \
"
