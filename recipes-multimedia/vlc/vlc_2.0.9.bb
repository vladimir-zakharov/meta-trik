DESCRIPTION = "Video player and streamer, Trik-dedicated build"
HOMEPAGE = "http://www.videolan.org"
LICENSE = "GPLv2"
SECTION = "multimedia"
PR = "r1"

DEPENDS  = "lua5.1 lua5.1-native dbus zlib libmad liba52 libav libgcrypt x264 ffmpeg alsa-lib libdvbpsi"

# v4l-utils is not required for vlc, but might be handy if present
RSUGGESTS_${PN} = "v4l-utils"

SRC_URI = "http://download.videolan.org/pub/videolan/vlc/${PV}/vlc-${PV}.tar.xz"
SRC_URI[md5sum] = "c96408fc0a6e6e7f85b37ab4d7d7c98f"
SRC_URI[sha256sum] = "c4bea9be211360ddbf29b93661fb1f33f7d5ce44166d829cbebfa01f303bfb30"

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"


inherit autotools gettext

EXTRA_OECONF += "--enable-dvbpsi"
# libxml2 is built with --disable-catalog in recipe and cannot be used
EXTRA_OECONF += "--disable-libxml2"
# Qt4 plugin breaks debugedit
EXTRA_OECONF += "--disable-qt4"
# X11 stuff is not applicable to Trik
EXTRA_OECONF += "--disable-glx --disable-xcb"
# Allow run as root
EXTRA_OECONF += "--enable-run-as-root"

FILES_${PN}-dbg += "${libdir}/vlc/plugins/*/.debug/"

# Do not use thumb as it is (probably) slower
ARM_INSTRUCTION_SET = "arm"








#TODO STUFF:
#DEPENDS = "libfribidi libtool gst-plugins-bad virtual/libsdl dbus gnutls tremor faad2 flac libxpm fluidsynth \
#           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libid3tag liba52 mpeg2dec', d)}"
#EXTRA_OECONF = 

