FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

do_install_append() {
	echo "tg:5:respawn:/etc/trik/trikGui.sh" >> ${D}${sysconfdir}/inittab
}

