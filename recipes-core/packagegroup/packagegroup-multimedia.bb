SUMMARY = "Multimedia libraries package"
DESCRIPTION = "Multimedia libraries and utilities"
LICENSE = "LGPL"
PR = "r0"

inherit packagegroup

RDEPENDS_${PN} = "\
  vlc \
  alsa-utils \
  pocketsphinx \
  v4l-utils \
 "

RRECOMMENDS_${PN} = "\
 "

