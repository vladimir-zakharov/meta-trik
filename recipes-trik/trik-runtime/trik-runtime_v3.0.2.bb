TAG = "${PV}"

SRC_URI = "git://github.com/trikset/trikRuntime.git;tag=${TAG} \
          file://trikGui.sh \
          file://qws_display.sh"

require trik-runtime.inc
