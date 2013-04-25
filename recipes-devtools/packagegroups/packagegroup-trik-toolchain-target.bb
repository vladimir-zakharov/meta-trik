SUMMARY = "Provides extra target libs for TRIK toolchain"
LICENSE = "MIT"

PR = "r1"

inherit packagegroup

RDEPENDS_${PN} += "\
    sphinxbase-dev \
    pocketsphinx-dev \
    "
