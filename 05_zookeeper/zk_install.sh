#!/bin/bash

###############################################
#
#   GIN INSTALL ZOOKEEPER ENV
#	需要配置 INSTALL_PATH, 执行shell需要参数$1(server序号,myid值)来指定,例: ./zk_install.sh 1
#	config INSTALL_PATH (for server id), execute like: ./zk_install.sh 1
#   需要配置 CLUSTER_HOSTS_ARRAY 单台则配置一个主机名即可
#	configure CLUSTER_HOSTS_ARRAY, you can configure a host name for a single
###############################################

# install_zk_path
INSTALL_PATH='/opt/software'
### 安装机器hosts(或ip),多台机器以空格分隔
### Install machine hosts, multiple machines separated by spaces
CLUSTER_HOSTS_ARRAY=(node02 node03 node04)

### -------- 无需修改项 --------
### 表示安装第几台,myid 会和该值一样
### number of current machinei, such as: sh zk_install.sh 1
MACHINE_ID=$1
PKG_NAME='zookeeper-3.4.14.tar.gz'
DIR_NAME='zookeeper-3.4.14'


function check_jdk()
{
	### zk install need JAVA_HOME.  
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
    PKG_NAME=`ls | grep zookeeper | grep .tar.gz`
	
	### check package
    if [ ! -f "${PKG_NAME}" ]
    then
		echo "you need install package!"
        exit
    fi    
 
    ### check unzip tmp dir
	DIR_NAME=`ls -l | grep '^d' |grep zookeeper |awk '{print$9}'`
	if [ -d "${DIR_NAME}" ];
    then
		echo "${DIR_NAME} is exit, rm unzip path"
        rm -rf "${DIR_NAME}"
	else
		echo "DIR_NAME is ok"
    fi
}

function install_info(){
	### execute shell param confirm
	if [ ! -z "$MACHINE_ID" ]; 
	then
		echo 'current MACHINE_ID='$MACHINE_ID
	else 
		### default value
		MACHINE_ID="1"
		echo "empty input param('$1'),using default 1" 
	fi
	
	echo
	echo "INSTALL_PATH: ${INSTALL_PATH}"
	echo "MACHINE_ID: ${MACHINE_ID}"
	echo "CLUSTER_HOSTS_ARRAY: ${CLUSTER_HOSTS_ARRAY[*]}"
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

function install_zk(){
	tar -xf $PKG_NAME
	### get file name
	DIR_NAME=`ls -l | grep '^d' |grep zookeeper |awk '{print$9}'`
	mv $DIR_NAME $INSTALL_PATH
	
	### zookeeper path
	TARGET_PATH=$INSTALL_PATH/$DIR_NAME
	### configuration
	cp $TARGET_PATH/conf/zoo_sample.cfg $TARGET_PATH/conf/zoo.cfg
	
	### configuration file path and data path
	zk_conf=$TARGET_PATH/conf/zoo.cfg
	zk_data=$TARGET_PATH/data
	
	### config data path
	mkdir -p $zk_data
	sed -i 's|dataDir=/tmp/zookeeper|dataDir='$zk_data'|g' $zk_conf
	
	### config cluster ip:port
	for (( i = 1; i <= "${#CLUSTER_HOSTS_ARRAY[@]}"; i++ ))
	do
		echo server.$i="${CLUSTER_HOSTS_ARRAY[$(($i-1))]}:2888:3888" >> $zk_conf
	done;
	
	### server name
	server=$2
	echo "server=$server"
	
	### config myid
	echo $MACHINE_ID > $zk_data/myid
	
	### config env
	if [[ -z $ZOOKEEPER_HOME ]];then
		echo "### zk env begin" >> /etc/profile
		echo "export ZOOKEEPER_HOME=$TARGET_PATH" >> /etc/profile
### use '' avoid $PATH resolved to actual value,if used "" $PATH need to be escaped like \$PATH
		echo 'export PATH=$PATH:$ZOOKEEPER_HOME/bin' >> /etc/profile
		echo "### zk env end" >> /etc/profile
	fi
	
	### start zk
	echo
	echo "you can use command to start zk..."
	echo "$TARGET_PATH/bin/zkServer.sh start"
	echo
}

 
function main()
{
	### Execute as needed
	check_jdk
	check_package
    install_info
	install_zk
}
 
# Execute main method 
main
# END




