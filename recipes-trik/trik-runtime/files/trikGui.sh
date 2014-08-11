#!/bin/sh

TRIKGUI_NAME=trikGui
TRIKGUI_PATH=/home/root/trik
TRIKGUI_OPS="-qws"

. /etc/profile.d/locale.sh
. /etc/profile.d/qws_display.sh

cd $TRIKGUI_PATH
./$TRIKGUI_NAME $TRIKGUI_OPS > /dev/null 2>&1

