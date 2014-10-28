BRANCH  = "master"
SRCREV	= "${AUTOREV}"
SRC_URI = "git://github.com/trikset/trikRuntime.git;branch=${BRANCH} \
	  file://trikGui.sh \
	  file://qws_display.sh"

require trik-runtime.inc
