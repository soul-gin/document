#!/bin/bash

echo "river deploy start, kill process ..."
ps -ef|grep tomcat_river|grep -v grep |awk '{print $2}'|xargs kill -9

echo "river kill end, start backup ROOT ..."
cur_date=`date +%Y-%m-%d`
tar -zcvf /home/admin/apps/shells/bak/river_${cur_date}_root.tar.gz /home/admin/apps/tomcat_river_9080/webapps/ROOT/

echo "river backup end, start rm logs and ROOT ..."
rm -rf /home/admin/apps/tomcat_river_9080/logs/*
rm -rf /home/admin/apps/tomcat_river_9080/webapps/ROOT/*

echo "river rm end, start unzip and deploy ..."
unzip /home/admin/apps/shells/war/river-release-1.0.8.war -d /home/admin/apps/tomcat_river_9080/webapps/ROOT/
cp /home/admin/apps/shells/war/application* /home/admin/apps/tomcat_river_9080/webapps/ROOT/WEB-INF/classes
/home/admin/apps/tomcat_river_9080/bin/startup.sh
tail -888f /home/admin/apps/tomcat_river_9080/logs/catalina.out