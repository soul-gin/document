#!/bin/bash

###############################################
#
#   GIN INSTALL LIVY ENV
#	
###############################################

### Directory name filter criteria
MARK='hadoop'
### install_path
INSTALL_PATH='/opt/software'
### node id(hostname)
#NODE_ID='node01'
NODE_ID=`hostname`
### Number of HDFS copies
REPLICATION_SIZE='1'
### DATA NODE
#DATA_NODE='node01'
DATA_NODE=`hostname`

### -------- 无需修改项 --------
### -------- No modification required --------
PKG_NAME='hadoop-2.6.5.tar.gz'
DIR_NAME='hadoop-2.6.5'


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
    PKG_NAME=`ls | grep ${MARK} | grep .tar.gz`
	
	### check package
    if [ ! -f "${PKG_NAME}" ]
    then
		echo "you need install package!"
        exit
    fi    
 
    ### check unzip tmp dir
	DIR_NAME=`ls -l | grep '^d' |grep ${MARK} |awk '{print$9}'`
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
	echo "MARK: ${MARK}"
	echo "INSTALL_PATH: ${INSTALL_PATH}"
	echo "NODE_ID: ${NODE_ID}"
	echo "REPLICATION_SIZE: ${REPLICATION_SIZE}"
	echo "DATA_NODE: ${DATA_NODE}"
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
	DIR_NAME=`ls -l | grep '^d' |grep ${MARK} |awk '{print$9}'`
	mv $DIR_NAME $INSTALL_PATH
	
	### neo4j-community path
	TARGET_PATH=$INSTALL_PATH/$DIR_NAME
	
	### configuration file path and data path
	path_bin=$TARGET_PATH/bin
	path_conf=$TARGET_PATH/etc/hadoop
	
	### apend settings
    echo "# hadoop environment begin" >> /etc/profile
    echo "HADOOP_HOME=${TARGET_PATH}" >>/etc/profile
    echo "PATH=\$PATH:\${HADOOP_HOME}/bin:\${HADOOP_HOME}/sbin" >>/etc/profile
    echo "export HADOOP_HOME" >>/etc/profile
    echo "# hadoop environment end" >>/etc/profile
	
	### To solve the problem that system variables cannot be obtained across servers
	sed -i 's|${JAVA_HOME}|'$JAVA_HOME'|g' $path_conf/hadoop-env.sh
	
	### config data node
	echo "$DATA_NODE" > $path_conf/slaves
	
	### core-site.xml config
cat > $path_conf/core-site.xml <<EOF
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
<configuration>
  <property>
    <name>fs.defaultFS</name>
    <value>hdfs://$NODE_ID:9000</value>
  </property>
</configuration>
EOF
	

	### hdfs-site.xml config
cat > $path_conf/hdfs-site.xml <<EOF
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
<configuration>
  <property>
    <name>dfs.replication</name>
    <value>$REPLICATION_SIZE</value>
  </property>
  <!-- namenode datanode config -->
  <property>
    <name>dfs.namenode.name.dir</name>
    <value>/var/bigdata/hadoop/local/dfs/name</value>
  </property>
  <property>
    <name>dfs.datanode.data.dir</name>
    <value>/var/bigdata/hadoop/local/dfs/data</value>
  </property>
  <!-- secondary config -->
  <property>
    <name>dfs.namenode.secondary.http-address</name>
    <value>$NODE_ID:50090</value>
  </property>
  <property>
    <name>dfs.namenode.checkpoint.dir</name>
    <value>/var/bigdata/hadoop/local/dfs/secondary</value>
  </property>
</configuration>
EOF
	
	### start,you should follow the order of command execution
	echo
	echo "you should follow the order of command execution!!!"
	echo "1-you can use command to source profile ..."
	echo "source /etc/profile"
	echo "2-you can use command to format hdfs namenode ..."
	echo "hdfs namenode -format"
	echo "3-you can use command to start hdfs datanode secondary..."
	echo "start-dfs.sh"
	echo "Accessing HDFS through browser"
	echo "http://$NODE_ID:50070"
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


