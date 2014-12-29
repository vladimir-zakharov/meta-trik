DESCRIPTION = "Configuration files for online package repositories aka feeds(Trik Edition)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"
PR = "r0"

PACKAGE_ARCH = "${MACHINE_ARCH}"
TRIKFEEDSERVER_BASE = "http://downloads.trikset.com/"
TRIKFEEDSERVER_PREFIX = "update_feeds/"

TRIKFEED_CONFIG="trik-feeds.conf"
do_compile() {
	mkdir -p ${S}/${sysconfdir}/opkg/
	archconf=${S}/${sysconfdir}/opkg/arch.conf
	version_file=${S}/${sysconfdir}/trikos_version
	ipkgarchs="all armv5te ${MACHINE_ARCH}"
	basefeedconf=${S}/${sysconfdir}/opkg/${TRIKFEED_CONFIG}
	priority=1
	rm -f $archconf
        for arch in $ipkgarchs; do
                echo "arch $arch $priority" >> $archconf
                priority=$(expr $priority + 5)
        done

	rm -f $basefeedconf
        for arch in $ipkgarchs; do
                echo "src/gz $arch ${TRIKFEEDSERVER_BASE}${TRIKFEEDSERVER_PREFIX}${TRIKOS_VERSION}/$arch" >> $basefeedconf
        done
	rm -rf $version_file
	echo "TRIK OS version ${TRIKOS_VERSION}" >>  $version_file
}
do_install(){
	install -d ${D}${sysconfdir}/opkg
        install -m 0644  ${S}/${sysconfdir}/opkg/${TRIKFEED_CONFIG} ${D}${sysconfdir}/opkg/
	install -m 0644 ${S}/${sysconfdir}/trikos_version  ${D}${sysconfdir}/
}

FILES_${PN} = "/etc/*"

