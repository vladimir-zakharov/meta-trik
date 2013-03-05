require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

PR = "r0"

PROVIDES = "linux-libc-headers"
RPROVIDES_${PN}-dev = "linux-libc-headers-dev"
RPROVIDES_${PN}-dbg = "linux-libc-headers-dbg"

SRCREV="${AUTOREV}"

SRC_URI = "git://git@tklab.math.spbu.ru/trick_linux_3_6.git;protocol=ssh"

S = "${WORKDIR}/git"




