DESCRIPTION = "Video player and streamer, Trik-dedicated build"
HOMEPAGE = "http://www.videolan.org"
LICENSE = "GPLv2"
SECTION = "multimedia"
PR = "r0"

DEPENDS = "lua5.1 lua5.1-native dbus zlib libmad libav libgcrypt x264"
# v4l-utils is not required for vlc, but might be handy if present
RSUGGESTS_${PN} = "v4l-utils"

SRC_URI = "http://download.videolan.org/pub/videolan/vlc/${PV}/vlc-${PV}.tar.xz"
SRC_URI[md5sum] = "b45be633c71dca04ca7d6c3d64dd728b"
SRC_URI[sha256sum] = "31cc98035e2ce36c71a8f105aa5a87e3d8b5e206a0b3f7208c5ced407cbe1963"

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"


inherit autotools gettext

# libxml2 is built with --disable-catalog in recipe and cannot be used
EXTRA_OECONF += "--disable-libxml2"
# Qt4 plugin breaks debugedit
EXTRA_OECONF += "--disable-qt4"
# X11 stuff is not applicable to Trik
EXTRA_OECONF += "--disable-glx --disable-xcb"
# Allow run as root
EXTRA_OECONF += "--enable-run-as-root"

FILES_${PN}-dbg += "${libdir}/vlc/plugins/*/.debug/"









#TODO STUFF:
#ARM_INSTRUCTION_SET = "arm"
#DEPENDS = "libfribidi libtool libgcrypt gst-plugins-bad virtual/libsdl qt4-x11-free dbus libxml2 gnutls tremor faad2 ffmpeg flac libxpm fluidsynth alsa-lib \
#           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad libid3tag liba52 mpeg2dec', d)}"
#EXTRA_OECONF = 

