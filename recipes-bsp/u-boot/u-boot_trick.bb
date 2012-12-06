require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"

COMPATIBLE_MACHINE = "trick2e"

PACKAGE_ARCH = "${MACHINE_ARCH}"
//todo repo
${REPO} = "git://12312"
SRC_URI = "${REPO}t;protocol=git;branch=${BRANCH}"
BRANCH = "master"
SRCREV = "6e710c61dba2665e01c900470a0a63743ff431c6"
EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} CC="${TARGET_PREFIX}gcc ${TOOLCHAIN_OPTIONS}"'
S = "${WORKDIR}/git"
UBOOT_SUFFIX = "bin"

