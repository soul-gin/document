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
    #判断应用PID是否存在, 存在则继续监控, 不存在则拉起并告警
    APP_PID=`ps -ef |grep $APP_FILE |grep -v grep |awk '{print $2}'`
    if [ ! -n "$APP_PID" ]; then
      echo "$APP_MSG"

      #调用企业微信小机器人的回调接口
      #wxNotify

      #调用重启脚本,将应用重新拉起
      nohup sh ./restart.sh >/dev/null 2>error_log.txt &
      echo "$APP_FILE restart ..."

      #将错误信息写入最新时间的日志文件
      #echo -e "\nERROR app not running\n" >> ./log/`ls ./log -t|grep "out_access_service.log" |head -n 1`
      #echo -e "\n ERROR : app not running ERROR IP=`grep IPADDR /etc/sysconfig/network-scripts/ifcfg-eth1|cut -d= -f2` \n" >> ./`ls ./ -t|grep "data_sync_service.log" |head -n 1`
      sleep 3s
    else
      echo "$APP_FILE $APP_PID is running"
      sleep 10s
    fi
done
