SUMMARY = "Provides extra target libs for TRIK toolchain"
LICENSE = "MIT"

PR = "r2"

inherit packagegroup

RDEPENDS_${PN} += "\
    linux-libc-headers-dev \
    kernel-dev \
    alsa-dev \
    sphinxbase-dev \
    pocketsphinx-dev \
    libnl-dev \
    libv4l-dev \
    "
