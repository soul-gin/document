#!/bin/sh

# vi ~/.bash_profile
# export APPS=/home/tongdun/apps
# source ~/.bash_profile

TIME=`date "+%Y-%m-%d_%H:%M:%S"`
TOMCAT_PRESERVER_7070=tomcat_preserver_7070
echo "TOMCAT-PRESERVER-7070 is $APPS/$TOMCAT_PRESERVER_7070"


echo "killing preserver..."
ps -ef|grep -v grep|grep tomcat|grep java|grep $TOMCAT_PRESERVER_7070|awk '{print "kill -9 "$2}'|sh


echo "clean preserver log..."
rm -rf $APPS/$TOMCAT_PRESERVER_7070/logs/*


sh $APPS/$TOMCAT_PRESERVER_7070/bin/startup.sh
echo "cd $APPS/$TOMCAT_PRESERVER_7070/logs/ && tail -888f $APPS/$TOMCAT_PRESERVER_7070/logs/catalina.out"
