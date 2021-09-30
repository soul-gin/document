#!/bin/bash

###############################################
#
#   GIN INSTALL KAFKA ENV
#	需要配置 INSTALL_PATH
#   执行shell需要参数$1(集群中broker序号), 本机主机名, 例: ./kfk_install.sh 1 node01
#	config INSTALL_PATH (for broker id), hostname, execute like: ./kfk_install.sh 1 node01
#   需要配置 ZOOKEEPER_CLUSTER 单台则配置一个主机名:端口即可
#	configure ZOOKEEPER_CLUSTER, you can configure a hostname:port for a single
###############################################

# install_kfk_path
INSTALL_PATH='/opt/software'
### Kafka links zookeeper cluster
ZOOKEEPER_CLUSTER='node02:2181,node03:2181,node04:2181'

### -------- 脚本入参项 --------
### 表示安装第几台,broker id 会和该值一样
### number of current machinei, such as: sh kfk_install.sh 1 node01
MACHINE_ID=$1
### 表示当前机器的主机名, 不能使用IP
### Indicates the host name of the current machine. IP cannot be used
LOACL_HOSTNAME=$2

### -------- 无需修改项 --------
PKG_NAME='kafka_2.11-2.2.0.tgz'
DIR_NAME='kafka_2.11-2.2.0'



function check_jdk()
{
	### kfk install need JAVA_HOME.  
	if [[ ! -d $JAVA_HOME ]];
	then
		echo "JAVA_HOME not set"
		exit 1
	else
		echo "JAVA_HOME=$JAVA_HOME"
	fi
} 

function check_package()
{
	### check install_path exists
	if [ ! -d "${INSTALL_PATH}" ];
	then
		echo "${INSTALL_PATH} not exit, mkdir"
		mkdir -p "${INSTALL_PATH}"
	else
		echo "${INSTALL_PATH} is exit"
	fi
	### get .tar.gz package name from current file
    PKG_NAME=`ls | grep kafka | grep .tgz`
	
	### check package
    if [ ! -f "${PKG_NAME}" ]
    then
		echo "you need install package!"
        exit
    fi    
 
    ### check unzip tmp dir
	DIR_NAME=`ls -l | grep '^d' |grep kafka |awk '{print$9}'`
	if [ -d "${DIR_NAME}" ];
    then
		echo "${DIR_NAME} is exit, rm unzip path"
        rm -rf "${DIR_NAME}"
	else
		echo "DIR_NAME is ok"
    fi
}

function install_info(){
	### execute shell param confirm 1
	if [ ! -z "$MACHINE_ID" ]; 
	then
		echo 'current MACHINE_ID='$MACHINE_ID
	else 
		### default value
		MACHINE_ID="1"
		echo "empty input param('$1'),using default 1" 
	fi
	
	### execute shell param confirm 2
	if [ ! -z "$LOACL_HOSTNAME" ]; 
	then
		echo 'current LOACL_HOSTNAME='$LOACL_HOSTNAME
	else 
		### default value
		LOACL_HOSTNAME="node01"
		echo "empty input param('$2'),using default node01" 
	fi
	
	echo
	echo "INSTALL_PATH: ${INSTALL_PATH}"
	echo "MACHINE_ID: ${MACHINE_ID}"
	echo "LOACL_HOSTNAME: ${LOACL_HOSTNAME}"
	echo "ZOOKEEPER_CLUSTER: ${ZOOKEEPER_CLUSTER}"
	echo

	while true; do
	    read -p "Check that the configuration, press [y/n] to continue: " yn
	    case $yn in
	        [Yy]* ) break;;
	        [Nn]* ) exit;;
	        * ) echo "please input y/n.";;
	    esac
	done
}

function install_kfk(){
	tar -xf $PKG_NAME
	### get file name
	DIR_NAME=`ls -l | grep '^d' |grep kafka |awk '{print$9}'`
	mv $DIR_NAME $INSTALL_PATH
	
	### kafka path
	TARGET_PATH=$INSTALL_PATH/$DIR_NAME
	
	### configuration file path and data path
	kfk_conf=$TARGET_PATH/config/server.properties
	kfk_data=$TARGET_PATH/data
	
	### config cluster
	### cluster id
	sed -i 's|broker.id=0|broker.id='$MACHINE_ID'|g' $kfk_conf
	### cluster hostname 
	sed -i 's|#listeners=PLAINTEXT://:9092|listeners=PLAINTEXT://'$LOACL_HOSTNAME':9092|g' $kfk_conf
	### cluster log data path
	mkdir -p $kfk_data
	sed -i 's|log.dirs=/tmp/kafka-logs|log.dirs='$kfk_data'|g' $kfk_conf
	### Kafka links zookeeper cluster
	sed -i 's|zookeeper.connect=.*|zookeeper.connect='$ZOOKEEPER_CLUSTER'|g' $kfk_conf
	
	 
	### config env
	if [[ -z $KAFKA_HOME ]];then
		echo "### kfk env begin" >> /etc/profile
		echo "export KAFKA_HOME=$TARGET_PATH" >> /etc/profile
### use '' avoid $PATH resolved to actual value,if used "" $PATH need to be escaped like \$PATH
		echo 'export PATH=$PATH:$KAFKA_HOME/bin' >> /etc/profile
		echo "### kfk env end" >> /etc/profile
	fi
	
	### start kfk
	echo
	echo "you can use command to start kfk..."
	echo "$TARGET_PATH/bin/kafka-server-start.sh -daemon $TARGET_PATH/config/server.properties"
	echo "or"
	echo "cd $TARGET_PATH/"
	echo "bin/kafka-server-start.sh -daemon config/server.properties"
	echo "kafka-console-producer.sh --broker-list `hostname`:9092  --topic topic01"
	echo "kafka-console-consumer.sh --bootstrap-server `hostname`:9092 --topic topic01 --group group01 --property print.key=true --property print.value=true --property key.separator=,"
	echo
}

 
function main()
{
	### Execute as needed
	check_jdk
	check_package
    install_info
	install_kfk
}
 
# Execute main method 
main
# END




