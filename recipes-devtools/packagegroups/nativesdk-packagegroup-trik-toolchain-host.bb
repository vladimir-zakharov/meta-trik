SUMMARY = "Provides extra host tools for TRIK toolchain"
LICENSE = "MIT"

PR = "r0"

inherit packagegroup

RDEPENDS_${PN} += "\
    nativesdk-make \
    "
