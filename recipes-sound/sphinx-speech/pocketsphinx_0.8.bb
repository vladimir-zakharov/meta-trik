DESCRIPTION = "CMU PocketSphinx - speech recognition engine for handhelds"
HOMEPAGE = "http://www.speech.cs.cmu.edu/pocketsphinx/"
LICENSE = "BSD"
DEPENDS = "sphinxbase"
PR="r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/cmusphinx/${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "9f6fb6277d57fb33d2c49d4184587d26"
SRC_URI[sha256sum] = "874c4c083d91c8ff26a2aec250b689e537912ff728923c141c4dac48662cce7a"

LIC_FILES_CHKSUM = "file://COPYING;md5=6601be289d6bcad899b6e71623ce2862"


inherit autotools

require sphinx-python.inc
EXTRA_OECONF += "${@get_sphinx_python_setting(bb, d)}"

PACKAGES =+ "${PN}-tools"
FILES_${PN}-tools = "${bindir} ${datadir}"
RDEPENDS_${PN}-tools += "sphinxbase-tools"
