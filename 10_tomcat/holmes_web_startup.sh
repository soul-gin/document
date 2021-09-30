#!/bin/bash

echo "holmes_web deploy start, kill process ..."
ps -ef|grep tomcat_holmes_web|grep -v grep |awk '{print $2}'|xargs kill -9

echo "holmes_web kill end, start backup ROOT ..."
cur_date=`date +%Y-%m-%d`
tar -zcvf /home/admin/apps/deploy/bak/holmes_web_${cur_date}_root.tar.gz /home/admin/apps/tomcat_holmes_web_9001/webapps/ROOT/

echo "holmes_web backup end, start rm logs and ROOT ..."
rm -rf /home/admin/apps/tomcat_holmes_web_9001/logs/*
rm -rf /home/admin/apps/tomcat_holmes_web_9001/webapps/ROOT/*

echo "holmes_web rm end, start unzip and deploy ..."
unzip /home/admin/apps/deploy/war/holmes-web-release-2.8.0.war -d /home/admin/apps/tomcat_holmes_web_9001/webapps/ROOT/
cp /home/admin/apps/deploy/holmes_web_deploy/holmes-admin.properties /home/admin/apps/tomcat_holmes_web_9001/webapps/ROOT/WEB-INF/classes/properties/
cp /home/admin/apps/deploy/holmes_web_deploy/application.properties /home/admin/apps/tomcat_holmes_web_9001/webapps/ROOT/WEB-INF/classes/
/home/admin/apps/tomcat_holmes_web_9001/bin/startup.sh

echo ""
echo "useful command : "
echo "cd /home/admin/apps/tomcat_holmes_web_9001/ && tail -888f /home/admin/apps/tomcat_holmes_web_9001/logs/catalina.out"
echo ""
