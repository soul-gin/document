#!/bin/bash

###############################################
#
#   GIN INSTALL LIVY ENV
#	需要配置 INSTALL_PATH SPARK_HOME HADOOP_CONF_DIR
#	config INSTALL_PATH SPARK_HOME HADOOP_CONF_DIR
#
#   需要准备jar,放到和安装包平级的 JAR_PATH 目录下,获取方式
#	$HADOOP_HOME/share/hadoop/common/lib/jersey-core-1.9.jar
#	$HADOOP_HOME/share/hadoop/yarn/lib/jersey-client-1.9.jar
#	或maven仓库下载
#	<groupId>com.sun.jersey</groupId>
#   <artifactId>jersey-client</artifactId>
#   <artifactId>jersey-core</artifactId>
#
#	ZOOKEEPER_QUORUM : zk cluster ip:port,ip:port
###############################################

# install_neo4j_path
INSTALL_PATH='/home/admin/local'
### spark hadoop
SPARK_HOME='discovery/spark'
HADOOP_CONF_DIR='hadoop/etc/hadoop'

### jersey-client jersey-core 
JAR_PATH='conf'

### zk config
### you need pre prepared configuration file!!!
### 需要事先准备配置文件,对应打开注释,在value位置上配置对应变量名!!!
### match key 
### livy.server.recovery.state-store=zookeeper
### livy.server.recovery.state-store.url=ZOOKEEPER_QUORUM
ZOOKEEPER_QUORUM='master70:2181,master71:2181,master72:2181'


### -------- 无需修改项 --------
### -------- No modification required --------
PKG_NAME='apache-livy-0.6.0-incubating-bin.tgz'
DIR_NAME='livy-0.6.0'


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
    PKG_NAME=`ls | grep livy | grep .tgz`
	
	### check package
    if [ ! -f "${PKG_NAME}" ]
    then
		echo "you need install package!"
        exit
    fi    
 
    ### check unzip tmp dir
	DIR_NAME=`ls -l | grep '^d' |grep livy |awk '{print$9}'`
	if [ -d "${DIR_NAME}" ];
    then
		echo "${DIR_NAME} is exit, rm unzip path"
        rm -rf "${DIR_NAME}"
	else
		echo "DIR_NAME is ok"
    fi
}

function install_info(){
	echo
	echo "INSTALL_PATH: ${INSTALL_PATH}"
	echo "SPARK_HOME: ${SPARK_HOME}"
	echo "HADOOP_CONF_DIR: ${HADOOP_CONF_DIR}"
	echo "JAR_PATH: ${JAR_PATH}"
	echo "ZOOKEEPER_QUORUM: ${ZOOKEEPER_QUORUM}"
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

function install_package(){
	tar -xf $PKG_NAME
	### get file name
	DIR_NAME=`ls -l | grep '^d' |grep livy |awk '{print$9}'`
	mv $DIR_NAME $INSTALL_PATH
	
	### neo4j-community path
	TARGET_PATH=$INSTALL_PATH/$DIR_NAME
	mkdir $TARGET_PATH/logs
	### configuration file path and data path
	path_conf=$TARGET_PATH/conf
	path_plugins=$TARGET_PATH/plugins
	
	### 使用的是
	### use pre prepared JAR_PATH
	cp $JAR_PATH/jersey-core-1.19.jar $TARGET_PATH/jars/
	cp $JAR_PATH/jersey-client-1.19.jar $TARGET_PATH/jars/
	
	### livy config
cat >> $TARGET_PATH/conf/livy.conf <<EOF
### 默认使用hiveContext
### Use hivecontext by default
livy.repl.enableHiveContext=true

### 开启用户代理
### Open user agent
livy.impersonation.enabled=true

### 设置session空闲过期时间
### Set session idle expiration time
livy.server.session.timeout=1h
livy.server.session.factory=yarn

### off:默认为关闭失败恢复功能.recovery:当配置为recovery时Livy就会开启失败恢复功能
### Off: the default is to turn off the failed recovery function. 
### Recovery: when configured as recovery, Livy will turn on the failed recovery function
livy.server.recovery.mode=recovery

### 配置将元信息存储在何种可靠存储上,当前支持filesystem和zookeeper
### Configure what kind of reliable storage meta information is stored on.
### Currently, filesystem and zookeeper are supported
livy.server.recovery.state-store=zookeeper

### 配置具体的存储路径
### Configure specific storage paths
livy.server.recovery.state-store.url=$ZOOKEEPER_QUORUM
livy.spark.master=yarn
livy.spark.deploy-mode=cluster
livy.server.port=8998
EOF
	

	### livy env config hadoop spark home
	cp $TARGET_PATH/conf/livy-env.sh.template $TARGET_PATH/conf/livy-env.sh
cat >> $TARGET_PATH/conf/livy-env.sh <<EOF
export SPARK_HOME=$SPARK_HOME
export HADOOP_CONF_DIR=$HADOOP_CONF_DIR
EOF
	
	### start
	echo
	echo "you can use command to start ..."
	echo "$TARGET_PATH/bin/livy-server start 1>/dev/null 2>&1 &"
	echo
}

 
function main()
{
	### Execute as needed
	check_jdk
	check_package
    install_info
	install_package
}
 
# Execute main method 
main
# END


