#!/bin/bash

# date time
ADATE=`date +%Y%m%d%H%M%S`
# the directory where the script is executed
APP_HOME=$(cd `dirname $0`; pwd)
# app pid
APP_PID=0



# need alter begin
# app name
SERVER_NAME=preserver
# gc log dir
GC_LOGS=$APP_HOME/../gc_logs
# external profile path
CONFIG_PATH=$APP_HOME/config/application.properties
# need alter end


# ensure that the GC log directory exists
if [ ! -d $GC_LOGS ];then
  mkdir -p $GC_LOGS
fi
# gc file path
GC_LOG_PATH=$GC_LOGS/gc-$SERVER_NAME-$ADATE.log


checkConfig(){
  CONFIG_PATH=$APP_HOME/config/application.properties
  if [ -f $CONFIG_PATH ];then
    # use file in config dir
    echo "configFile in config path: " + $CONFIG_PATH;
  else
    CONFIG_PATH=$APP_HOME/`ls -t |grep application.properties |head -n1`
    if [ -f $CONFIG_PATH ];then
      # use file in config dir
      echo "configFile in app: " + $CONFIG_PATH;
    else
      echo "configFile not found error";
      exit 0
    fi
  fi
}


# check config file
#checkConfig
#echo "config normal end...";


#JMX监控需用到
JMX="-Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=1091 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false"
#JVM参数
#JVM_OPTS="-Dname=$SERVER_NAME -Dspring.config.location=$CONFIG_PATH -Xms256m -Xmx256m -XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=128m"
JVM_OPTS="-Dname=$SERVER_NAME -Xms256m -Xmx256m -XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=128m"
JVM_GC_OPTS="-XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDateStamps -Xloggc:$GC_LOG_PATH -XX:+PrintGCDetails"

appJarName=$2
if [ -z $appJarName ];then
    appJarName=`ls -t |grep .jar$ |head -n1`
fi
JAR_FILE=$APP_HOME"/"$appJarName
echo '应用jar包绝对路径: ' $JAR_FILE



start(){
  chechPid
  if [ ! -n "$APP_PID" ]; then
    #JAVA_CMD="nohup java -server -jar $JVM_OPTS $JAR_FILE > /dev/null 2>&1 &"
    #su - $RUNNING_USER -c "$JAVA_CMD"
    nohup java -server -jar $JVM_OPTS $JVM_GC_OPTS $JAR_FILE > /dev/null 2>&1 &
    echo "---------------------------------"
    echo "启动完成，按CTRL+C退出日志界面即可>>>>>"
    echo "---------------------------------"
    sleep 3s
  else
      echo "$SERVER_NAME is runing PID: $APP_PID"
  fi

}


status(){
   chechPid
   if [ ! -n "$APP_PID" ]; then
     echo "$SERVER_NAME not runing"
   else
     echo "$SERVER_NAME runing PID: $APP_PID"
      sleep 4s
   fi
}

chechPid(){
    APP_PID=`ps -ef |grep $JAR_FILE |grep -v grep |awk '{print $2}'`
}

stop(){
    chechPid
    if [ ! -n "$APP_PID" ]; then
     echo "$SERVER_NAME not runing"
    else
      #dump
      echo "$SERVER_NAME stop..."
      kill $APP_PID
    fi
}

restart(){
    stop
    sleep 3s
    start
}
dump(){
    DUMP_DIR=$GC_LOGS/dump
    if [ ! -d $DUMP_DIR ]; then
        mkdir $DUMP_DIR
    fi
    DUMP_DATE=`date +%Y%m%d%H%M%S`
    DATE_DIR=$DUMP_DIR/$DUMP_DATE
    if [ ! -d $DATE_DIR ]; then
        mkdir $DATE_DIR
    fi

    echo  "Dumping the $SERVER_NAME ...\c"

    PIDS=`ps -ef | grep java | grep $JAR_FILE |awk '{print $2}'`
    for PID in $PIDS ; do
        jstack $PID > $DATE_DIR/jstack-$PID.dump 2>&1
        echo -e  "PID=$PID .\c"
        jinfo $PID > $DATE_DIR/jinfo-$PID.dump 2>&1
        echo -e  ".\c"
        jstat -gcutil $PID > $DATE_DIR/jstat-gcutil-$PID.dump 2>&1
        echo -e  ".\c"
        jstat -gccapacity $PID > $DATE_DIR/jstat-gccapacity-$PID.dump 2>&1
        echo -e  ".\c"
        jmap $PID > $DATE_DIR/jmap-$PID.dump 2>&1
        echo -e  ".\c"
        jmap -heap $PID > $DATE_DIR/jmap-heap-$PID.dump 2>&1
        echo -e  ".\c"
        jmap -histo $PID > $DATE_DIR/jmap-histo-$PID.dump 2>&1
        echo -e  ".\c"
        if [ -r /usr/sbin/lsof ]; then
        /usr/sbin/lsof -p $PID > $DATE_DIR/lsof-$PID.dump
        echo -e  ".\c"
        fi
    done

    if [ -r /bin/netstat ]; then
    /bin/netstat -an > $DATE_DIR/netstat.dump 2>&1
    echo -e  "netstat.dump ..."
    fi
    if [ -r /usr/bin/iostat ]; then
    /usr/bin/iostat > $DATE_DIR/iostat.dump 2>&1
    echo -e  "iostat.dump ..."
    fi
    if [ -r /usr/bin/mpstat ]; then
    /usr/bin/mpstat > $DATE_DIR/mpstat.dump 2>&1
    echo -e  "mpstat.dump ..."
    fi
    if [ -r /usr/bin/vmstat ]; then
    /usr/bin/vmstat > $DATE_DIR/vmstat.dump 2>&1
    echo -e  "vmstat.dump ..."
    fi
    if [ -r /usr/bin/free ]; then
    /usr/bin/free -t > $DATE_DIR/free.dump 2>&1
    echo -e  "free.dump ..."
    fi
    if [ -r /usr/bin/sar ]; then
    /usr/bin/sar > $DATE_DIR/sar.dump 2>&1
    echo -e  ".\c"
    fi
    if [ -r /usr/bin/uptime ]; then
    /usr/bin/uptime > $DATE_DIR/uptime.dump 2>&1
    echo -e  ".\c"
    fi

    echo "OK!"
    echo "DUMP: $DATE_DIR"
}

case $1 in
          start) start;;
          stop)  stop;;
          restart)  restart;;
          status)  status;;
          dump)  dump;;
              *)  echo "require start|stop|restart|status|dump"  ;;
esac

