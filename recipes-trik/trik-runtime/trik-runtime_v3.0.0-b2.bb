TAG = "${PV}"

SRC_URI = "git://github.com/trikset/trikRuntime.git;tag=${TAG} \
	  file://0001-Fix-for-script-error-reporting-in-case-of-interrupti.patch \
          file://trikGui.sh \
          file://qws_display.sh"

require trik-runtime.inc
