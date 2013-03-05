DESCRIPTION = "Task for extra drivers for Texas Instruments SoCs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit packagegroup

RDEPENDS_${PN} = "\
	linux-firmware-wl12xx \
	rfkill \
	cpufrequtils \
	"

RRECOMMENDS_${PN} = "\
	\
	kernel-module-bluetooth \
	kernel-module-hci-usb \
	kernel-module-hci-uart \
	\
	kernel-module-wl12xx \
	kernel-module-wl12xx-sdio \
	\
	kernel-module-wl1271 \
	kernel-module-wl1271-sdio \
	kernel-module-btwilink \
	"
