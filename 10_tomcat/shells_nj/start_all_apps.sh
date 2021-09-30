#!/bin/bash

echo  "start all apps begin ..."

sh kill_all_apps.sh
sh rm_logs.sh


/home/admin/apps/tomcat_atreus_9090/bin/startup.sh
sleep 30s

/home/admin/apps/tomcat_bifrost_9081/bin/startup.sh
sleep 30s

/home/admin/apps/tomcat_preserver_7070/bin/startup.sh
sleep 30s

/home/admin/apps/tomcat_river_9080/bin/startup.sh
sleep 30s

/home/admin/apps/tomcat_salaxy_9004/bin/startup.sh
sleep 30s

/home/admin/apps/tomcat_freyr_9088/bin/startup.sh
sleep 30s

/home/admin/apps/tomcat_consumer_9005/bin/startup.sh
sleep 30s

/home/admin/apps/tomcat_holmes_api_9002/bin/startup.sh
sleep 30s

/home/admin/apps/tomcat_holmes_web_9001/bin/startup.sh
sleep 30s

/home/admin/apps/tomcat_holmes_python_9003/start.sh


echo  "start all apps end ..."



