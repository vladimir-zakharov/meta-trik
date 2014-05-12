#!/bin/sh

### BEGIN INIT INFO
# Provides:          app
# Required-Start:
# Required-Stop:
# Should-Start:
# Default-Start:     2 3 4 5
# Default-Stop:      0 1 6
# Short-Description: start trik-gui daemon
### END INIT INFO


TRIKGUI_NAME=trikGui
TRIKGUI_PATH=/home/root/trik
TRIKGUI_OPS="-qws"
TRIKGUI_PRIORITY=-1

TRIKGUI_PIDDIR=/var/run/
TRIKGUI_PID=$PIDDIR/$NAME.pid

. /etc/init.d/functions

test -x $TRIKGUI_PATH/$TRIKGUI_NAME || exit 0

enviroment () {
	export LD_LIBRARY_PATH=$TRIKGUI_PATH:$LD_LIBRARY_PATH
	cd $TRIKGUI_PATH

}
case $1 in 
	start)
		echo -n "Starting  $TRIKGUI_NAME daemon : "
		enviroment
		start-stop-daemon -Svb -x ./$TRIKGUI_NAME -- $TRIKGUI_OPS
		echo "done."
		;;
	stop)
		echo -n "Stopping $TRIKGUI_NAME daemon: "
		start-stop-daemon -Kvx ./$TRIKGUI_NAME
		echo "done."
		;;
	restart|force-reload)
		echo -n "Restarting $TRIKGUI_NAME daemon: "
		enviroment
		start-stop-daemon -Kvx ./$TRIKGUI_NAME
		sleep 2
		start-stop-daemon -Svb -x ./$TRIKGUI_NAME -- $TRIKGUI_OPS
		echo "done."
		;;
	status)
		enviroment 
		status ./$TRIKGUI_NAME
	        exit $?
		;;
	*)
		echo "Usage: $0 {start|stop|force-reload|restart|status}"
        	exit 1
        ;;
esac
exit 0


		

