#!/bin/sh
### BEGIN INIT INFO
# Provides:          hostname
# Required-Start:
# Required-Stop:
# Default-Start:     S
# Default-Stop:
# Short-Description: Generate hostname

if [ ! -d /etc/trik/custom ]; then
        mkdir -p /etc/trik/custom/
fi
if [ ! -f /etc/trik/custom/hostname ]; then
        echo "trik-$(cat /sys/class/net/wlan0/address | tail -c 9 | sed 's/://g')" > /etc/trik/custom/hostname
fi

if [ ! -L /etc/hostname ]; then
        ln -s /etc/trik/custom/hostname /etc/hostname
fi


