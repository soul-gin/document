#!/bin/bash

### mysql passwd
MYSQL_PASSWORD=$1

### sftp passwd
APP_PASSWORD=$2

### app dir enum
APP_DIR_ARRAY=(bifrost_8072 consumer_8075 freyr_8077 holmes-api-9002 holmes-python-9003 holmes-web-9001 preserver_8070 river_8071 salaxy_8074 spartan_8073)
APP_DIR=""

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
  echo "APP_DIR_ARRAY: ${APP_DIR_ARRAY[*]}"
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


###alter 
function alter_bifrost()
{

###mysql password
  if [ -z $MYSQL_PASSWORD ];
  then
    echo "MYSQL_PASSWORD not set"
  else
    find $APP_DIR/* -type f \( -name *.properties -o -name *.yml \) |xargs sed -i -r "s#(^spring.datasource.druid.primary.password=)(.*$)#\1$PASSWORD#g" 
    find $APP_DIR/* -type f \( -name *.properties -o -name *.yml \) |xargs sed -i -r "s#(^druid.publickey=)(.*)#\1$PUBLIC_KEY#g" 
  fi

###app sftp password
  if [ -z $APP_PASSWORD ];
  then
    echo "APP_PASSWORD not set"
  else
    find $APP_DIR/* -type f \( -name *.properties -o -name *.yml \) |xargs sed -i -r "s#(^bifrost.sftp.password=)(.*)#\1$APP_PASSWORD#g"
  fi

}


###alter
function alter_consumer()
{

###mysql password
  if [ -z $MYSQL_PASSWORD ];
  then
    echo "MYSQL_PASSWORD not set"
  else
    find $APP_DIR/* -type f \( -name *.properties -o -name *.yml \) |xargs sed -i -r "s#(^forseti.database.password=)(.*$)#\1$PASSWORD#g"
    find $APP_DIR/* -type f \( -name *.properties -o -name *.yml \) |xargs sed -i -r "s#(^forseti.database.connectionProperties.*config.decrypt.key=)(.*)#\1$PUBLIC_KEY#g"
  fi

}



###alter
function alter_freyr()
{

###mysql password
  if [ -z $MYSQL_PASSWORD ];
  then
    echo "MYSQL_PASSWORD not set"
  else
    find $APP_DIR/* -type f \( -name *.properties -o -name *.yml \) |xargs sed -i -r "s#(^jdbc.password=)(.*$)#\1$PASSWORD#g"
    find $APP_DIR/* -type f \( -name *.properties -o -name *.yml \) |xargs sed -i -r "s#(^jdbc.public.key=)(.*)#\1$PUBLIC_KEY#g"
  fi

}



###alter
function alter_holmes-api()
{

###mysql password
  if [ -z $MYSQL_PASSWORD ];
  then
    echo "MYSQL_PASSWORD not set"
  else
    find $APP_DIR/* -type f \( -name *.properties -o -name *.yml \) |xargs sed -i -r "s#(^jdbc.holmes.database.password=)(.*$)#\1$PASSWORD#g"
    find $APP_DIR/* -type f \( -name *.properties -o -name *.yml \) |xargs sed -i -r "s#(^publicKey=)(.*)#\1$PUBLIC_KEY#g"
  fi

}



###alter
function alter_holmes-web()
{

###mysql password
  if [ -z $MYSQL_PASSWORD ];
  then
    echo "MYSQL_PASSWORD not set"
  else
    find $APP_DIR/* -type f \( -name *.properties -o -name *.yml \) |xargs sed -i -r "s#(^spring.datasource.password=)(.*$)#\1$MYSQL_PASSWORD#g"
  fi

}



###alter
function alter_holmes-python()
{

###mysql password
  if [ -z $MYSQL_PASSWORD ];
  then
    echo "MYSQL_PASSWORD not set"
  else
    find $APP_DIR/* -type f \( -name *.properties -o -name *.conf \) |xargs sed -i -r "s#(^mysql_password =)(.*$)#\1$MYSQL_PASSWORD#g"
  fi

}


###alter
function alter_preserver()
{

###mysql password
  if [ -z $MYSQL_PASSWORD ];
  then
    echo "MYSQL_PASSWORD not set"
  else
    find $APP_DIR/* -type f \( -name *.properties -o -name *.yml \) |xargs sed -i -r "s#(^jdbc.database.password=)(.*$)#\1$PASSWORD#g"
    find $APP_DIR/* -type f \( -name *.properties -o -name *.yml \) |xargs sed -i -r "s#(^jdbc.database.publickey=)(.*)#\1$PUBLIC_KEY#g"
  fi

}



###alter
function alter_river()
{

###mysql password
  if [ -z $MYSQL_PASSWORD ];
  then
    echo "MYSQL_PASSWORD not set"
  else
    find $APP_DIR/* -type f \( -name *.properties -o -name *.yml \) |xargs sed -i -r "s#(^spring.datasource.password=)(.*$)#\1$PASSWORD#g"
    find $APP_DIR/* -type f \( -name *.properties -o -name *.yml \) |xargs sed -i -r "s#(^spring.datasource.connectionProperties.*config.decrypt.key=)(.*)#\1$PUBLIC_KEY#g"
  fi

}



###alter
function alter_salaxy()
{

###mysql password
  if [ -z $MYSQL_PASSWORD ];
  then
    echo "MYSQL_PASSWORD not set"
  else
    find $APP_DIR/* -type f \( -name *.properties -o -name *.yml \) |xargs sed -i -r "s#(^spring.datasource.druid.api.password=)(.*$)#\1$PASSWORD#g"
    find $APP_DIR/* -type f \( -name *.properties -o -name *.yml \) |xargs sed -i -r "s#(^spring.datasource.druid.api.connectionProperties.*config.decrypt.key=)(.*)#\1$PUBLIC_KEY#g"
  fi

}



###alter
function alter_spartan()
{

###mysql password
  if [ -z $MYSQL_PASSWORD ];
  then
    echo "MYSQL_PASSWORD not set"
  else
    find $APP_DIR/* -type f \( -name *.properties -o -name *.yml \) |xargs sed -i -r "s#(^spring.datasource.druid.primary.password=)(.*$)#\1$PASSWORD#g"
    find $APP_DIR/* -type f \( -name *.properties -o -name *.yml \) |xargs sed -i -r "s#(^druid.publickey=)(.*)#\1$PUBLIC_KEY#g"
  fi

###app sftp password
  if [ -z $APP_PASSWORD ];
  then
    echo "APP_PASSWORD not set"
  else
    find $APP_DIR/* -type f \( -name *.properties -o -name *.yml \) |xargs sed -i -r "s#(^spartan.sftp.password=)(.*)#\1$APP_PASSWORD#g"
  fi

}



### alter config
function alter_config()
{ 
  for (( i = 1; i <= "${#APP_DIR_ARRAY[@]}"; i++ ))
  do
    APP_DIR=${APP_DIR_ARRAY[$(($i-1))]}
    echo "$APP_DIR 配置替换..."
    #判断文件夹是否存在 -d
    if [[ ! -d "$APP_DIR" ]]; then
      echo "文件夹 $APP_DIR 不存在"
    else
      echo "文件夹 $APP_DIR 存在"
      ###invoke function
      case $APP_DIR in
        bifrost_8072) alter_bifrost;;
        consumer_8075)  alter_consumer;;
        freyr_8077)  alter_freyr;;
        holmes-api-9002)  alter_holmes-api;;
        holmes-python-9003)  alter_holmes-python;;
        holmes-web-9001)  alter_holmes-web;;
        preserver_8070)  alter_preserver;;
        river_8071)  alter_river;;
        salaxy_8074)  alter_salaxy;;
        spartan_8073)  alter_spartan;;
        *)  echo "error dir"  ;;
      esac
      echo "$APP_DIR 替换完成"
    fi
  done;
}
###invoke function
alter_config








