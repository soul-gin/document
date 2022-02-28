#!/bin/bash

APP_PID=0
APP_IP=`grep IPADDR /etc/sysconfig/network-scripts/ifcfg-eth1|cut -d= -f2`
APP_FILE="out_access_service"
APP_MSG="$APP_FILE not running, ip=$APP_IP"
#APP_DIR="/root/out-access"
APP_DIR="/root/shell"


wxNotify(){
    curl 'https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=70f91c97-b235-4b1f-81b0-13e13476c41c' \
           -H 'Content-Type: application/json' \
           -d "
           {
                \"msgtype\": \"text\",
                \"text\": {
                    \"content\": \"$APP_MSG\"
                }
           }"
}


while true
do
    echo  -e  "job begin ... path= $APP_DIR"
    cd $APP_DIR
    APP_PID=`ps -ef |grep $APP_FILE |grep -v grep |awk '{print $2}'`
    if [ ! -n "$APP_PID" ]; then
      echo "$APP_MSG"
      #wxNotify
      nohup sh ./restart.sh >/dev/null 2>error_log.txt &
      echo "$APP_FILE restart ..."
      sleep 3s
    else
      echo "$APP_FILE $APP_PID is running"
      sleep 10s
    fi
done
