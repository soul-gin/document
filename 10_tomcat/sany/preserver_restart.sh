#!/bin/sh

TOMCAT_PRESERVER_7070=tomcat-preserver-7070

echo "TOMCAT-PRESERVER-7070 is $apps/$TOMCAT_PRESERVER_7070"

echo "killing preserver..."

ps -ef|grep -v grep|grep tomcat|grep java|grep $TOMCAT_PRESERVER_7070|awk '{print "kill -9 "$2}'|sh

rm -rf $apps/$TOMCAT_PRESERVER_7070/logs/*

sh $apps/$TOMCAT_PRESERVER_7070/bin/startup.sh

echo "cd $apps/$TOMCAT_PRESERVER_7070/logs/ && tail -888f $apps/$TOMCAT_PRESERVER_7070/logs/catalina.out"
