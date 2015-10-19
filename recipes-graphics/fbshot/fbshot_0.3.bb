SUMMARY = "FBShot is a framebuffer screenshot program"
HOMEPAGE = "http://www.sfires.net/fbshot/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=ea5bed2f60d357618ca161ad539f7c0a"
SECTION = "console/utils"
DEPENDS = "libpng zlib"
SRC_URI = "http://www.sfires.net/stuff/${PN}/${BP}.tar.gz \
	   file://0001-cross-compile-build.patch"

inherit autotools-brokensep

S = "${WORKDIR}/${BP}"

SRC_URI[md5sum] = "2cc6cc25cdc4cd447a8b0a9662907635"
SRC_URI[sha256sum] = "4cceeed1f9ddfeeffe5e4027fad696ea732af4dd90c28b2cfe9a3bb31787903b"

#do_configure_prepend() {
#    sed -i 's|$(DESTDIR)/usr/man/|$(DESTDIR)${mandir}/|g' ${S}/Makefile
#}
