#!/bin/bash

echo  "kill all apps begin ..."

# kill river
pid_river=$(ps -ef|grep tomcat_river|grep -v grep |awk '{print $2}')

if [ ! $pid_river ];then
    # empty
    echo  "river has not start ..."
else
    # alive
    echo "begin kill river ..." && ps -ef|grep tomcat_river|grep -v grep |awk '{print $2}'|xargs kill -9
fi


# kill bifrost
pid_bifrost=$(ps -ef|grep tomcat_bifrost|grep -v grep |awk '{print $2}')

if [ ! $pid_bifrost ];then
    # empty
    echo  "bifrost has not start ..."
else
    # alive
    echo "begin kill bifrost ..." && ps -ef|grep tomcat_bifrost|grep -v grep |awk '{print $2}'|xargs kill -9
fi


# kill atreus
pid_atreus=$(ps -ef|grep tomcat_atreus|grep -v grep |awk '{print $2}')

if [ ! $pid_atreus ];then
    # empty
    echo  "atreus has not start ..."
else
    # alive
    echo "begin kill atreus ..." && ps -ef|grep tomcat_atreus|grep -v grep |awk '{print $2}'|xargs kill -9
fi


# kill salaxy
pid_salaxy=$(ps -ef|grep tomcat_salaxy|grep -v grep |awk '{print $2}')

if [ ! $pid_salaxy ];then
    # empty
    echo  "salaxy has not start ..."
else
    # alive
    echo "begin kill salaxy ..." && ps -ef|grep tomcat_salaxy|grep -v grep |awk '{print $2}'|xargs kill -9
fi


# kill preserver
pid_preserver=$(ps -ef|grep tomcat_preserver|grep -v grep |awk '{print $2}')

if [ ! $pid_preserver ];then
    # empty
    echo  "preserver has not start ..."
else
    # alive
    echo "begin kill preserver ..." && ps -ef|grep tomcat_preserver|grep -v grep |awk '{print $2}'|xargs kill -9
fi


# kill holmes_api
pid_holmes_api=$(ps -ef|grep tomcat_holmes_api|grep -v grep |awk '{print $2}')

if [ ! $pid_holmes_api ];then
    # empty
    echo  "holmes_api has not start ..."
else
    # alive
    echo "begin kill holmes_api ..." && ps -ef|grep tomcat_holmes_api|grep -v grep |awk '{print $2}'|xargs kill -9
fi


# kill holmes_web
pid_holmes_web=$(ps -ef|grep tomcat_holmes_web|grep -v grep |awk '{print $2}')

if [ ! $pid_holmes_web ];then
    # empty
    echo  "holmes_web has not start ..."
else
    # alive
    echo "begin kill holmes_web ..." && ps -ef|grep tomcat_holmes_web|grep -v grep |awk '{print $2}'|xargs kill -9
fi


# kill freyr
pid_freyr=$(ps -ef|grep tomcat_freyr|grep -v grep |awk '{print $2}')

if [ ! $pid_freyr ];then
    # empty
    echo  "freyr has not start ..."
else
    # alive
    echo "begin kill freyr ..." && ps -ef|grep tomcat_freyr|grep -v grep |awk '{print $2}'|xargs kill -9
fi


# kill consumer
pid_consumer=$(ps -ef|grep tomcat_consumer|grep -v grep |awk '{print $2}')

if [ ! $pid_consumer ];then
    # empty
    echo  "consumer has not start ..."
else
    # alive
    echo "begin kill consumer ..." && ps -ef|grep tomcat_consumer|grep -v grep |awk '{print $2}'|xargs kill -9
fi


echo  "kill all apps end ..."

