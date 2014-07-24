SUMMARY = "Install default locale for system"
DESCRIPTION		= ""
LICENSE			= "MIT"
LIC_FILES_CHKSUM	="file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"
SRC_URI			= "file://locale.sh"
do_install () {
	install -m 755 -d ${D}${sysconfdir}/profile.d/
	install -m 644 ${WORKDIR}/locale.sh ${D}${sysconfdir}/profile.d/
}

