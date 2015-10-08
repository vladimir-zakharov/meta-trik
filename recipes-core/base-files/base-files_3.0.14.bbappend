# look for files in this layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
hostname = ""

inherit user-partion

do_install_append () {
	install -v -m 0777 -d ${D}${TRIK_USER_PARTION_CREATION_DIR}
	generate_fstab >> ${D}${sysconfdir}/fstab
}
generate_fstab() {
	echo "# additional entries for trik user partion"
	echo "/dev/mmcblk0p2 ${TRIK_USER_PARTION_CREATION_DIR} vfat defaults,sync,noauto  0  0"
} 
