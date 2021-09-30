#!/bin/sh
TOMCAT_RIVER_9080=$apps/tomcat-river-9080
TOMCAT_BIFROST_9081=$apps/tomcat-bifrost-9081
TOMCAT_ATREUS_9090=$apps/tomcat-atreus-9090
TOMCAT_API_9004=$apps/tomcat-api-9004
TOMCAT_HOLMES_WEB_9001=$apps/tomcat-holmes-web-9001
TOMCAT_HOLMES_API_9002=$apps/tomcat-holmes-api-9002
TOMCAT_PRESERVER_7070=$apps/tomcat-preserver-7070


echo "TOMCAT-RIVER-9080 is $TOMCAT_RIVER_9080"
echo "TOMCAT-BIFROST-9081 is $TOMCAT_BIFROST_9081"
echo "TOMCAT-ATREUS-9090 is $TOMCAT_ATREUS_9090"
echo "TOMCAT-API-9004 is $TOMCAT_API_9004"
echo "TOMCAT-HOLMES-WEB-9001 is $TOMCAT_HOLMES_WEB_9001"
echo "TOMCAT-HOLMES-API-9002 is $TOMCAT_HOLMES_API_9002"
echo "TOMCAT-PRESERVER-7070 is $TOMCAT_PRESERVER_7070"


echo "killing tomcat..."
# 找到tomcat的进程id，并kill掉
#ps -ef | grep -v grep | grep -i '$TOMCAT-RIVER-9080\|$TOMCAT-BIFROST-9081\|$TOMCAT-ATREUS-9090\|$TOMCAT-API-9004\|$TOMCAT-HOLMES-WEB-9001\|$TOMCAT-HOLMES-API-9002\|$TOMCAT-PRESERVER-7070' | awk '{print $2}' | sed -e "s/^/kill -9 /g" | sh -
ps -ef|grep -v grep|grep tomcat| grep java |awk '{print "kill -9 "$2}'|sh
echo "killed tomcat"

echo "starting kow tomcat..."
# 重新启动tomcat
sh $TOMCAT_RIVER_9080/bin/startup.sh
sleep 30
sh $TOMCAT_BIFROST_9081/bin/startup.sh
sleep 30
sh $TOMCAT_ATREUS_9090/bin/startup.sh
sleep 30
sh $TOMCAT_API_9004/bin/startup.sh
sleep 30
sh $TOMCAT_HOLMES_WEB_9001/bin/startup.sh
sleep 30
sh $TOMCAT_HOLMES_API_9002/bin/startup.sh
sleep 30
sh $TOMCAT_PRESERVER_7070/bin/startup.sh
