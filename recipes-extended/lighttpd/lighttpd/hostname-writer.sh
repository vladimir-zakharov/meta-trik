#! /bin/sh

if [ "$REQUEST_METHOD" = "POST" ]; then
    read params

    hostname=${params#hostname=}

    {
        echo $hostname > /etc/hostname &&
        hosts=$(sed '/127\.0\.1\.1/d' /etc/hosts) &&
        echo -e "$hosts" > /etc/hosts &&
        echo -e "\n127.0.1.1\t$hostname" >> /etc/hosts &&
        echo "OK"
    } || {
        echo $'HTTP/1.1 500 Internal Server Error\r\n'
    }
fi
