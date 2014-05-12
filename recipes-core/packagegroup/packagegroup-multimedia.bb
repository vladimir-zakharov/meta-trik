SUMMARY = "Multimedia libraries package"
DESCRIPTION = "Multimedia libraries and utilities"
LICENSE = "LGPL"
PR = "r0"

inherit packagegroup

RDEPENDS_${PN} = "\
  vlc \
  alsa-utils \
  pocketsphinx \
  pocketsphinx-tools \
  sphinxtrain \
  espeak \
  flite-alsa \
  v4l-utils \
  gst-meta-base \
  gst-meta-audio \
  gst-meta-video \
 "

RRECOMMENDS_${PN} = "\
 "

