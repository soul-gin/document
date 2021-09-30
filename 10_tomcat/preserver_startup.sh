#!/bin/bash

echo "preserver deploy start, kill process ..."
ps -ef|grep tomcat_preserver|grep -v grep |awk '{print $2}'|xargs kill -9

echo "preserver kill end, start backup ROOT ..."
cur_date=`date +%Y-%m-%d`
tar -zcvf /home/admin/apps/shells/bak/preserver_${cur_date}_root.tar.gz /home/admin/apps/tomcat_preserver_7070/webapps/ROOT/

echo "preserver backup end, start rm logs and ROOT ..."
rm -rf /home/admin/apps/tomcat_preserver_7070/logs/*
rm -rf /home/admin/apps/tomcat_preserver_7070/webapps/ROOT/*

echo "preserver rm end, start unzip and deploy ..."
unzip /home/admin/apps/shells/war/preserver-release-2.4.0.war -d /home/admin/apps/tomcat_preserver_7070/webapps/ROOT/
cp /home/admin/apps/shells/preserver_deploy/application.properties /home/admin/apps/tomcat_preserver_7070/webapps/ROOT/WEB-INF/classes
/home/admin/apps/tomcat_preserver_7070/bin/startup.sh
tail -888f /home/admin/apps/tomcat_preserver_7070/logs/catalina.out
