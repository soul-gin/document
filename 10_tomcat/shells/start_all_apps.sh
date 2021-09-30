#!/bin/bash

echo  "start all apps begin ..."

sh kill_all_apps.sh

rm -rf /home/admin/apps/tomcat_atreus_9090/logs/*
/home/admin/apps/tomcat_atreus_9090/bin/startup.sh

sleep 30s

rm -rf /home/admin/apps/tomcat_bifrost_9081/logs/*
/home/admin/apps/tomcat_bifrost_9081/bin/startup.sh

sleep 30s

rm -rf /home/admin/apps/tomcat_preserver_7070/logs/*
/home/admin/apps/tomcat_preserver_7070/bin/startup.sh

sleep 30s

rm -rf /home/admin/apps/tomcat_river_9080/logs/*
/home/admin/apps/tomcat_river_9080/bin/startup.sh

sleep 30s


rm -rf /home/admin/apps/tomcat_salaxy_9004/logs/*
/home/admin/apps/tomcat_salaxy_9004/bin/startup.sh

sleep 30s


rm -rf /home/admin/apps/tomcat_holmes_api_9002/logs/*
/home/admin/apps/tomcat_holmes_api_9002/bin/startup.sh

sleep 30s


rm -rf /home/admin/apps/tomcat_holmes_web_9001/logs/*
/home/admin/apps/tomcat_holmes_web_9001/bin/startup.sh

sleep 30s

/home/admin/apps/tomcat_holmes_python_9003/start.sh


echo  "start all apps end ..."



