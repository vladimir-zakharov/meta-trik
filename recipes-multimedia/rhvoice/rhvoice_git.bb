SUMMARY = "RHVoice speech synthesis engine"
HOMEPAGE = "http://github.com/Olga-Yakovleva/RHVoice.git"
LICENSE = "LGPLv3+ & GPLv3+"
LIC_FILES_CHKSUM="file://COPYING;md5=d32239bcb673463ab874e80d47fae504\
                    file://COPYING.LESSER;md5=e6a600fd5e1d9cbde2d983680233ad02"

inherit scons pkgconfig 
#inherit distro_features_check

REQUIRED_DISTRO_FEATURES="alsa portaudio"

DEPENDS +=  "portaudio-v19"
RDEPENDS_${PN} += "portaudio-v19"

PULSE_rhvoice = "${@bb.utils.contains('DISTRO_FEATURES', 'pulseaudio', 'pulseaudio', '', d)}"
DEPENDS += "${PULSE_rhvoice}"
RDEPENDS_${PN} += "${PULSE_rhvoice}"

SRC_URI = "git://github.com/iakov/RHVoice.git;branch=TRIKhotfix"
#SRCREV = "master"
SRCREV = "TRIKhotfix"

PV = "0.4+git${SRCPV}"

S = "${WORKDIR}/git"
L = "${datadir}/RHVoice"

FILES_${PN} += "${sysconfdir}/RHVoice\
                ${datadir}/RHVoice/languages/English\
                ${datadir}/RHVoice/languages/Russian\
                ${datadir}/RHVoice/voices/aleksandr\
                ${datadir}/RHVoice/voices/elena\
                ${datadir}/RHVoice/voices/anna\
                ${datadir}/RHVoice/voices/irina\
                ${datadir}/RHVoice/voices/alan\
"
EXTRA_OESCONS = "sysconfdir={$D}${sysconfdir}"
