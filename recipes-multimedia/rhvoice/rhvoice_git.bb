SUMMARY = "RHVoice speech synthesis engine"
HOMEPAGE = "http://github.com/Olga-Yakovleva/RHVoice.git"
LICENSE = "LGPLv3+ & GPLv3+"
LIC_FILES_CHKSUM="file://COPYING;md5=d32239bcb673463ab874e80d47fae504\
                    file://COPYING.LESSER;md5=e6a600fd5e1d9cbde2d983680233ad02"

inherit scons pkgconfig
DEPENDS ?= ""
#DEPENDS = "glibmm" 

DEPENDS +=  "libao"
RDEPENDS_${PN} += "libao"

PULSE_rhvoice = "${@bb.utils.contains('DISTRO_FEATURES', 'pulseaudio', 'pulseaudio', '', d)}"
DEPENDS += "${PULSE_rhvoice}"
RDEPENDS_${PN} += "${PULSE_rhvoice}"

SRC_URI = "git://github.com/iakov/RHVoice.git;branch=TRIKhotfix"
#SRCREV = "master"
SRCREV = "TRIKhotfix"

PV = "0.4+git${SRCPV}"

S = "${WORKDIR}/git"
L = "${datadir}/RHVoice"

FILES_${PN} += "${datadir}/RHVoice"
EXTRA_OESCONS = ""

do_install () {
        install -p -D -T -m 0644 ${S}/config/RHVoice.conf ${D}${sysconfdir}/RHVoice/RHVoice.conf  
        for voice in irina aleksandr elena anna alan
        do
           install -p -m 0644 -d ${S}/data/voices/${voice} ${D}${L}/voices/${voice}   
        done

        for lang in English Russian
        do
           install -p -m 0644 -d ${S}/data/voices/${lang} ${D}${L}/languages/${lang}   
        done
		
	
}


