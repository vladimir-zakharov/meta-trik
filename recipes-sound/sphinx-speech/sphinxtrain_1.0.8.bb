DESCRIPTION = "CMU Sphinx speech recognition acoustic model training tool"
HOMEPAGE = "http://www.speech.cs.cmu.edu/pocketsphinx/"
LICENSE = "BSD"
DEPENDS = "sphinxbase"
RDEPENDS_${PN} += "sphinxbase-tools python"
PR="r0"

BBCLASSEXTEND += "native nativesdk"

SRC_URI = "${SOURCEFORGE_MIRROR}/cmusphinx/sphinxtrain-${PV}.tar.gz"
SRC_URI[md5sum] = "0f7155ba92fbdec169c92c1759303106"
SRC_URI[sha256sum] = "548e3e513ceaa1b2fd6fd7ed1724349e0a4bf7bdeb11be9c91787e6f2b865203"

LIC_FILES_CHKSUM = "file://COPYING;md5=ba401e3f5796dc515ebb00dae158e604"


inherit autotools perlnative

require sphinx-python.inc
EXTRA_OECONF += "${@get_sphinx_python_setting(bb, d)}"

FILES_${PN}-dbg += "${libdir}/sphinxtrain/sphinxtrain/.debug/"
