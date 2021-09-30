#!/bin/bash

echo "atreus deploy start, kill process ..."
ps -ef|grep tomcat_atreus|grep -v grep |awk '{print $2}'|xargs kill -9

echo "atreus kill end, start backup ROOT ..."
cur_date=`date +%Y-%m-%d`
tar -zcvf /home/admin/apps/shells/bak/atreus_${cur_date}_root.tar.gz /home/admin/apps/tomcat_atreus_9090/webapps/ROOT/

echo "atreus backup end, start rm logs and ROOT ..."
rm -rf /home/admin/apps/tomcat_atreus_9090/logs/*
rm -rf /home/admin/apps/tomcat_atreus_9090/webapps/ROOT/*

echo "atreus rm end, start unzip and deploy ..."
unzip /home/admin/apps/shells/war/atreus-release-3.0.0.war -d /home/admin/apps/tomcat_atreus_9090/webapps/ROOT/
cp /home/admin/apps/shells/atreus_deploy/application* /home/admin/apps/tomcat_atreus_9090/webapps/ROOT/WEB-INF/classes
/home/admin/apps/tomcat_atreus_9090/bin/startup.sh
tail -888f /home/admin/apps/tomcat_atreus_9090/logs/catalina.out