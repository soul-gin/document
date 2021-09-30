#!/bin/sh

# vi ~/.bash_profile
# export APPS=/home/tongdun/apps
# source ~/.bash_profile

TIME=`date "+%Y-%m-%d_%H:%M:%S"`
TOMCAT_PRESERVER_7070=tomcat_preserver_7070

echo "TOMCAT-PRESERVER-7070 is $APPS/$TOMCAT_PRESERVER_7070"

echo "killing preserver..."
ps -ef|grep -v grep|grep tomcat|grep java|grep $TOMCAT_PRESERVER_7070|awk '{print "kill -9 "$2}'|sh

echo "backup preserver root..."
tar -zcvf $APPS/deploy/bak/preserver_${TIME}_root.tar.gz $APPS/tomcat_preserver_7070/webapps/ROOT/

echo "clean preserver log root..."
rm -rf $APPS/$TOMCAT_PRESERVER_7070/logs/*
rm -rf $APPS/$TOMCAT_PRESERVER_7070/webapps/ROOT/*

cp /home/tongdun/maven/package/jlcw/preserver/target/preserver-release-2.2.0.war $APPS/deploy/war/
unzip $APPS/deploy/war/preserver-release-2.2.0.war -d $APPS/$TOMCAT_PRESERVER_7070/webapps/ROOT/


mv $APPS/deploy/war/preserver-release-2.2.0.war $APPS/deploy/war/preserver-release-2.2.0_${TIME}.war

sh $APPS/$TOMCAT_PRESERVER_7070/bin/startup.sh

echo "cd $APPS/$TOMCAT_PRESERVER_7070/logs/ && tail -888f $APPS/$TOMCAT_PRESERVER_7070/logs/catalina.out"

/home/tongdun/apps/tomcat_preserver_7070/webapps/ROOT/WEB-INF/classes/cn/tongdun/preserver/controller