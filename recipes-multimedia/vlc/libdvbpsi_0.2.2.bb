DESCRIPTION = "Libdvbpsi "
HOMEPAGE = "http://www.videolan.org"
LICENSE = "GPLv2"
SECTION = "multimedia"
PR = "r1"

DEPENDS  = ""


SRC_URI = "http://download.videolan.org/pub/videolan/${PN}/${PV}/${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "9bdd8044e7fa684f2363ab1020c4c8a9"
SRC_URI[sha256sum] = "74e0e24c84f396d4678044c01cab3384c57c16013e49470f89cc1b8a66add96d"

LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"


inherit autotools gettext

