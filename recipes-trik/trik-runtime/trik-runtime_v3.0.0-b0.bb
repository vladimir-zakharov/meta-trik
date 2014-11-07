TAG = "${PV}"

SRC_URI = "git://github.com/trikset/trikRuntime.git;tag=${TAG} \
          file://0001-Updated-config-for-videosensors-made-trikGui-reappea.patch \
          file://trikGui.sh \
          file://qws_display.sh"

require trik-runtime.inc
