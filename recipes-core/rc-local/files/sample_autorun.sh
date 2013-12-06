#!/bin/sh

### BEGIN INIT INFO
# Provides:          app
# Required-Start:    
# Required-Stop:     
# Should-Start:      
# Default-Start:     2 3 4 5
# Default-Stop:      0 1 6
# Short-Description: start App daemon
### END INIT INFO


DAEMON_NAME=trikGui
DAEMON_PATH=/home/root/trik
DAEMON_OPS="-qws"
DAEMON_PRIORITY=-1
 
DAEMON_PIDDIR=/var/run/
DAEMON_PID=$PIDDIR/$NAME.pid

. /etc/init.d/functions

test -x $DAEMON_PATH/$NAME || exit 0

enviroment () {
	export LD_LIBRARY_PATH=$DAEMON_PATH:$LD_LIBRARY_PATH
	cd $DAEMON_PATH

}
case $1 in 
	start)
		echo -n "Starting  $DAEMON_NAME daemon : "
		enviroment
		start-stop-daemon -Svb -x ./$DAEMON_NAME -- $DAEMON_OPS 
		echo "done."
		;;
	stop)
		echo -n "Stopping $NAME daemon: "
		start-stop-daemon -Kvx ./$DAEMON_NAME
		echo "done."
		;;
	restart|force-reload)
		echo -n "Restarting $NAME daemon: "
		enviroment
		start-stop-daemon -Kvx ./$DAEMON_NAME
		sleep 2 
		start-stop-daemon -Svb -x ./$DAEMON_NAME -- $DAEMON_OPS
		echo "done."
		;;
	status)
		enviroment 
		status ./$NAME
	        exit $?
		;;
	*)
		echo "Usage: $0 {start|stop|force-reload|restart|status}"
        	exit 1
        ;;
esac
exit 0


		

