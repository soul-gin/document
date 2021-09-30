#!/bin/sh

TOMCAT_PRESERVER_7070=tomcat-preserver-7070

echo "TOMCAT-PRESERVER-7070 is $apps/$TOMCAT_PRESERVER_7070"

echo "killing preserver..."

ps -ef|grep -v grep|grep tomcat|grep java|grep $TOMCAT_PRESERVER_7070|awk '{print "kill -9 "$2}'|sh

rm -rf $apps/$TOMCAT_PRESERVER_7070/logs/*
rm -rf $apps/$TOMCAT_PRESERVER_7070/webapps/ROOT/*

unzip $apps/deploy/war/kratos-preserver-4.3.2.war -d $apps/$TOMCAT_PRESERVER_7070/webapps/ROOT/

TIME=`date "+%Y-%m-%d-%H:%M:%S"`
mv $apps/deploy/war/kratos-preserver-4.3.2.war $apps/deploy/war/kratos-preserver-4.3.2_${TIME}.war

sh $apps/$TOMCAT_PRESERVER_7070/bin/startup.sh

echo "cd $apps/$TOMCAT_PRESERVER_7070/logs/ && tail -888f $apps/$TOMCAT_PRESERVER_7070/logs/catalina.out"
