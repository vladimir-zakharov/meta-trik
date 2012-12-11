inherit kernel
require recipes-kernel/linux/linux-yocto.inc

DESCRIPTION = "Linux kernel for OMAP L138 processors"
KERNEL_IMAGETYPE = "uImage"
LICENSE = "GPlv2"

PV = "3.6"
# v3.2.28 tag

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
MACHINE_KERNEL_PR_append = "a"

SRC_URI = "file:///media/CyberTech/robots_old/robot/linux/linux-3.6"
SRC_URI_append = " file://defconfig "

# Override COMPATIBLE_MACHINE to include your machine in a bbappend
# file. Leaving it empty here ensures an early explicit build failure.
COMPATIBLE_MACHINE = "trickr2e"

