EXTRA_OECONF += "--enable-search-domains"

pkg_postinst_${PN} () {
	sed -e '/^hosts:/s/\s*\<mdns\>//' \
		-e 's/\(^hosts:.*\)\(\<files\>\)\(.*\)\(\<dns\>\)\(.*\)/\1\2 mdns\3\4\5/' \
		-i $D${sysconfdir}/nsswitch.conf
}


pkg_prerm_${PN} () {
	sed -e '/^hosts:/s/\s*\<mdns\>//' \
		-i $D${sysconfdir}/nsswitch.conf
}
