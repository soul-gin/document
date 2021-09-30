#!/bin/bash

###############################################
#
#   GIN INSTALL NEO4J ENV
#	需要配置 INSTALL_PATH
#	config INSTALL_PATH 
#   需要准备配置文件(可先解压一份出来修改)
#	pre prepared configuration file
###############################################

# install_neo4j_path
INSTALL_PATH='/home/admin/local'

### neo4j jvm config
### you need pre prepared configuration file!!!
### 需要事先准备配置文件,对应打开注释,在value位置上配置对应变量名!!!
### match key 
### dbms.memory.heap.initial.size, dbms.memory.heap.max.size, dbms.memory.pagecache.size
### dbms.connector.bolt.enabled=true, dbms.connector.http.enabled=true, dbms.connector.https.enabled=true
### dbms.connector.bolt.listen_address=:, dbms.connector.http.listen_address=:, dbms.connector.https.listen_address=:
DBMS_MEMORY_HEAP_INITIAL_SIZE=1g
DBMS_MEMORY_HEAP_MAX_SIZE=1g
DBMS_MEMORY_PAGECACHE_SIZE=1g
BOLT_PORT=7687
HTTP_PORT=7474
HTTPS_PORT=7473

### -------- 无需修改项 --------
### -------- No modification required --------
PKG_NAME='neo4j-community-3.5.5-unix.tar.gz'
DIR_NAME='neo4j-community-3.5.5'


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
    PKG_NAME=`ls | grep neo4j-community | grep .tar.gz`
	
	### check package
    if [ ! -f "${PKG_NAME}" ]
    then
		echo "you need install package!"
        exit
    fi    
 
    ### check unzip tmp dir
	DIR_NAME=`ls -l | grep '^d' |grep neo4j-community |awk '{print$9}'`
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
	echo "DBMS_MEMORY_HEAP_INITIAL_SIZE: ${DBMS_MEMORY_HEAP_INITIAL_SIZE}"
	echo "DBMS_MEMORY_HEAP_MAX_SIZE: ${DBMS_MEMORY_HEAP_MAX_SIZE}"
	echo "DBMS_MEMORY_PAGECACHE_SIZE: ${DBMS_MEMORY_PAGECACHE_SIZE}"
	echo "BOLT_PORT: ${BOLT_PORT}"
	echo "HTTP_PORT: ${HTTP_PORT}"
	echo "HTTPS_PORT: ${HTTPS_PORT}"
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
	DIR_NAME=`ls -l | grep '^d' |grep neo4j-community |awk '{print$9}'`
	mv $DIR_NAME $INSTALL_PATH
	
	### neo4j-community path
	TARGET_PATH=$INSTALL_PATH/$DIR_NAME
	### configuration file path and data path
	path_conf=$TARGET_PATH/conf
	path_plugins=$TARGET_PATH/plugins
	
	### 使用的是预先解压的配置文件,开启了部分配置项,并把需修改项的值替换为脚本变量名称
	### use pre prepared configuration
	cp conf/neo4j.conf $path_conf
	### use pre prepared plugins
	cp conf/apoc-3.5.0.6-all.jar $path_plugins
	
	### config jvm http
	sed -i 's|DBMS_MEMORY_HEAP_INITIAL_SIZE|'$DBMS_MEMORY_HEAP_INITIAL_SIZE'|g' $path_conf/neo4j.conf
	sed -i 's|DBMS_MEMORY_HEAP_MAX_SIZE|'$DBMS_MEMORY_HEAP_MAX_SIZE'|g' $path_conf/neo4j.conf
	sed -i 's|DBMS_MEMORY_PAGECACHE_SIZE|'$DBMS_MEMORY_PAGECACHE_SIZE'|g' $path_conf/neo4j.conf
	sed -i 's|BOLT_PORT|'$BOLT_PORT'|g' $path_conf/neo4j.conf
	sed -i 's|HTTP_PORT|'$HTTP_PORT'|g' $path_conf/neo4j.conf
	sed -i 's|HTTPS_PORT|'$HTTPS_PORT'|g' $path_conf/neo4j.conf
	
	
	### start
	echo
	echo "you can use command to start ..."
	echo "$TARGET_PATH/bin/neo4j start"
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


