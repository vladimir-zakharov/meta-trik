FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
RRECOMMENDS_winbind += "libnss-winbind"

inherit user-partion

do_install_append() {
	echo "\n[user-part]" >> ${D}${sysconfdir}/samba/smb.conf
	echo "\tpath = ${TRIK_USER_PARTION_CREATION_DIR}" >> ${D}${sysconfdir}/samba/smb.conf
	echo "\tpublic = yes" >> ${D}${sysconfdir}/samba/smb.conf
	echo "\twritable = yes" >> ${D}${sysconfdir}/samba/smb.conf
	echo "\tcomment = trik user partion" >> ${D}${sysconfdir}/samba/smb.conf
	echo "\tprintable = no" >> ${D}${sysconfdir}/samba/smb.conf
	echo "\tguest ok = yes" >> ${D}${sysconfdir}/samba/smb.conf

}

pkg_postinst_libnss-winbind () {
	sed -e '/^hosts:/s/\s*\<wins\>//' \
		-e 's/\(^hosts:.*\)\(\<files\>\)\(.*\)\(\<dns\>\)\(.*\)/\1\2\3 wins \4\5/' \
		-i $D${sysconfdir}/nsswitch.conf
}

pkg_prerm_libnss-winbind () {
	 sed -e '/^hosts:/s/\s*\<wins\>//' \
		-i $D${sysconfdir}/nsswitch.conf 
}



