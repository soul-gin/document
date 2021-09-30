#!/bin/bash

### mysql passwd
MYSQL_PASSWORD=$1

### sftp passwd
APP_PASSWORD=$2

### app dir enum
APP_DIR="/home/admin/deploy"

###Java runtime environment is required
###Druid-1.0.26.jar and shell script should be in the same level directory
function check_jdk()
{
  ### need JAVA_HOME.  
  if [[ ! -d $JAVA_HOME ]];
  then
    echo "JAVA_HOME not set"
    exit 1
  else
    echo "JAVA_HOME=$JAVA_HOME"
  fi
}
###invoke function
check_jdk 


function install_info(){
  ### execute shell param confirm
  echo
  echo "MYSQL_PASSWORD: ${MYSQL_PASSWORD}"
  echo "APP_PASSWORD: ${APP_PASSWORD}"
  echo "APP_DIR: ${APP_DIR}"
  echo

  while true; do
    read -p "Check that the configuration, press [y/n] to continue: " yn
    case $yn in
      [Yy]* ) break;;
      [Nn]* ) exit;;
      * ) echo "please input Y/N.";;
    esac
  done
}
###invoke function
install_info


###get password & publicKey
function encrypt_mysql()
{
  if [ -z $MYSQL_PASSWORD ];
  then
    echo "MYSQL_PASSWORD not set" > key.tmp
  else
    java -cp druid-1.0.26.jar com.alibaba.druid.filter.config.ConfigTools $MYSQL_PASSWORD > key.tmp
  fi
}
###invoke function
encrypt_mysql

PASSWORD=`cat key.tmp |grep password:|cut -d: -f2`
PUBLIC_KEY=`cat key.tmp |grep publicKey:|cut -d: -f2`

echo $PASSWORD
echo $PUBLIC_KEY


###alter mysql passwd
function alter_mysql()
{
  if [ -z $MYSQL_PASSWORD ];
  then
    echo "MYSQL_PASSWORD not set"
  else
    find $APP_DIR/* -type f \( -name *.properties -o -name *.yml \) |xargs sed -i -r "s#(^spring.datasource.druid.primary.password=)(.*$)#\1$PASSWORD#g" 
    find $APP_DIR/* -type f \( -name *.properties -o -name *.yml \) |xargs sed -i -r "s#(^druid.publickey=)(.*)#\1$PUBLIC_KEY#g" 
  fi
}


#alter app passwd
function alter_app()
{
  if [ -z $APP_PASSWORD ];
  then
    echo "APP_PASSWORD not set"
  else
    find $APP_DIR/* -type f \( -name *.properties -o -name *.yml \) |xargs sed -i -r "s#(^bifrost.sftp.password=)(.*)#\1$APP_PASSWORD#g" 
  fi
}



### alter config
function alter_config()
{ 
  echo "$APP_DIR 配置替换..."
  #判断文件夹是否存在 -d
  if [[ ! -d "$APP_DIR" ]]; then
    echo "文件夹 $APP_DIR 不存在"
  else
    echo "文件夹 $APP_DIR 存在"
    ###invoke function
    alter_mysql
    alter_app
    echo "$APP_DIR 替换完成"
  fi
}
###invoke function
alter_config








