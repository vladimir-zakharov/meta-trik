SUMMARY = "Qt for Embedded Trik Linux (Qt without X11)"
PR = "r2"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = " \
        libqt-embeddedcore4 \
        libqt-embeddedgui4 \
	libqt-embeddeddbus4 \
        libqt-embeddednetwork4 \
        qt4-embedded-plugin-imageformat-jpeg \
        qt4-embedded-plugin-imageformat-tiff \
        qt4-embedded-plugin-mousedriver-tslib \
        qt4-embedded-plugin-sqldriver-sqlite \
"
