DESCRIPTION = "A Simple library for communicating with USB and Bluetooth HID devices on Linux, Mac, and Windows."
HOMEPAGE = "http://www.signal11.us/oss/hidapi/"

SECTION = "libs"
LICENSE = "LGPLv2.1+"
DEPENDS += "udev"
S="${WORKDIR}/git"
SRCREV="${AUTOREV}"

SRC_URI ="git://github.com/signal11/hidapi.git"

LIC_FILES_CHKSUM="file://LICENSE.txt;beginline=1;endline=355;md5=7c3949a631240cb6c31c50f3eb696077"

inherit autotools

