DESCRIPTION = "Base library for CMU Sphinx speech recognition engines"
HOMEPAGE = "http://www.speech.cs.cmu.edu/pocketsphinx/"
LICENSE = "BSD"
DEPENDS = "pulseaudio libsndfile1"
# Native picks any available sound lib, SDK build insists on alsa-lib
DEPENDS_class-native = ""
DEPENDS_class-nativesdk = "alsa-lib"
PR="r0"

BBCLASSEXTEND += "native nativesdk"

SRC_URI = "${SOURCEFORGE_MIRROR}/cmusphinx/sphinxbase-${PV}.tar.gz"
SRC_URI[md5sum] = "7335d233f7ad4ecc4b508aec7b5dc101"
SRC_URI[sha256sum] = "55708944872bab1015b8ae07b379bf463764f469163a8fd114cbb16c5e486ca8"

LIC_FILES_CHKSUM = "file://COPYING;md5=c550e8ca1106e5eeaf4e2b4cbf960fcf"


inherit autotools

EXTRA_OECONF += "--enable-threads"
require sphinx-python.inc
EXTRA_OECONF += "${@get_sphinx_python_setting(bb, d)}"
require sphinx-fpu.inc
EXTRA_OECONF += "${@get_sphinx_fpu_setting(bb, d)}"

PACKAGES =+ "${PN}-tools"
FILES_${PN}-tools = "${bindir}/* ${datadir}"
