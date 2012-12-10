inherit kernel
require recipes-kernel/linux/linux-yocto.inc
require conf/machine/include/omapl138.inc

DESCRIPTION = "Linux kernel for OMAP L138 processors"
KERNEL_IMAGETYPE = "uImage"
LICENSE = "GPlv2"

PV = "3.6.9"
# v3.2.28 tag
SRCREV_pn-${PN} = "072e44f15d6cfabe5b5f02c58ca7b058c03cc111"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
MACHINE_KERNEL_PR_append = "a"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-3.6.y;protocol=git \
           file://0001-arm-davinci-da850-add-mux-configuration-for-LCD_PCLK.patch \
           file://0002-mma7660fc-accelerometer.patch \
           file://0003-arm-davinci-add-trikboard.patch"
SRC_URI_append = " file://defconfig "

# Override COMPATIBLE_MACHINE to include your machine in a bbappend
# file. Leaving it empty here ensures an early explicit build failure.
COMPATIBLE_MACHINE = "trickr2e"

