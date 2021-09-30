#!/bin/bash

echo "holmes_api deploy start, kill process ..."
ps -ef|grep tomcat_holmes_api|grep -v grep |awk '{print $2}'|xargs kill -9

echo "holmes_api kill end, start backup ROOT ..."
cur_date=`date +%Y-%m-%d`
tar -zcvf /home/admin/apps/deploy/bak/holmes_api_${cur_date}_root.tar.gz /home/admin/apps/tomcat_holmes_api_9002/webapps/ROOT/

echo "holmes_api backup end, start rm logs and ROOT ..."
rm -rf /home/admin/apps/tomcat_holmes_api_9002/logs/*
rm -rf /home/admin/apps/tomcat_holmes_api_9002/webapps/ROOT/*

echo "holmes_api rm end, start unzip and deploy ..."
unzip /home/admin/apps/deploy/war/holmes-api-web-release-2.8.0.war -d /home/admin/apps/tomcat_holmes_api_9002/webapps/ROOT/
cp /home/admin/apps/deploy/holmes_api_deploy/holmes-api.properties /home/admin/apps/tomcat_holmes_api_9002/webapps/ROOT/WEB-INF/classes/properties/
/home/admin/apps/tomcat_holmes_api_9002/bin/startup.sh

echo ""
echo "useful command : "
echo "cd /home/admin/apps/tomcat_holmes_api_9002/ && tail -888f /home/admin/apps/tomcat_holmes_api_9002/logs/catalina.out"
echo ""
