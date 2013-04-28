DESCRIPTION = "Video player and streamer, Trik-dedicated build"
HOMEPAGE = "http://www.videolan.org"
LICENSE = "GPLv2"
SECTION = "multimedia"
PR = "r0"

SRC_URI = "http://download.videolan.org/pub/videolan/vlc/${PV}/vlc-${PV}.tar.xz"
SRC_URI[md5sum] = "b45be633c71dca04ca7d6c3d64dd728b"
SRC_URI[sha256sum] = "31cc98035e2ce36c71a8f105aa5a87e3d8b5e206a0b3f7208c5ced407cbe1963"

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"


inherit autotools gettext

# libxml2 has --disable-catalog in recipe and thus is not compatible
EXTRA_OECONF += "--disable-libxml2"
# Qt4 plugin breaks debugedit
EXTRA_OECONF += "--disable-qt4"

FILES_${PN}-dbg += "${libdir}/vlc/plugins/*/.debug/"

