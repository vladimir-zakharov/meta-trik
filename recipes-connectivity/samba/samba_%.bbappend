RRECOMMENDS_winbind += "libnss-winbind"

pkg_postinst_libnss-winbind () {
	sed -e '/^hosts:/s/\s*\<wins\>//' \
		-e 's/\(^hosts:.*\)\(\<files\>\)\(.*\)\(\<dns\>\)\(.*\)/\1\2\3 wins \4\5/' \
		-i $D${sysconfdir}/nsswitch.conf
}

pkg_prerm_libnss-winbind () {
	 sed -e '/^hosts:/s/\s*\<wins\>//' \
		-i $D${sysconfdir}/nsswitch.conf 
}



