#!/bin/bash

###############################################
#GIN INSTALL LIVY ENV
#HOST    NN  NN  SNN  DN  ZKFC  ZK  RM   
#node01	 *                *
#node02	     *   *    *   *     * 
#node03	              *         *   *     
#node04	              *         *   *     
###############################################

### Directory name filter criteria
MARK='hadoop'
### install_path
INSTALL_PATH='/opt/software'
### NODE
NODE_ID='node01'
### Number of HDFS copies
REPLICATION_SIZE='2'
### DATA NODE
DATA_NODE2='node02'
DATA_NODE3='node03'
DATA_NODE4='node04'

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
	echo "DATA_NODE2: ${DATA_NODE2}"
	echo "DATA_NODE3: ${DATA_NODE3}"
	echo "DATA_NODE4: ${DATA_NODE4}"
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
	echo -e "$DATA_NODE2\n$DATA_NODE3\n$DATA_NODE4" > $path_conf/slaves
	
	### mapred-site.xml config
cat > $path_conf/mapred-site.xml <<EOF
<?xml version="1.0"?>
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
<configuration>
  <property>
    <name>mapreduce.framework.name</name>
    <value>yarn</value>
  </property>
</configuration>

EOF

    ### yarn-site.xml config
cat > $path_conf/yarn-site.xml <<EOF
<?xml version="1.0"?>
<configuration>
  <property>
    <name>yarn.nodemanager.aux-services</name>
    <value>mapreduce_shuffle</value>
  </property>

  <property>
    <name>yarn.resourcemanager.ha.enabled</name>
    <value>true</value>
  </property>
  <property>
    <name>yarn.resourcemanager.zk-address</name>
    <value>$DATA_NODE2:2181,$DATA_NODE3:2181,$DATA_NODE4:2181</value>
  </property>
  
  <!-- 自定义资源管理器名称 -->
  <property>
    <name>yarn.resourcemanager.cluster-id</name>
    <value>myresourcemanager</value>
  </property>

  <property>
    <name>yarn.resourcemanager.ha.rm-ids</name>
    <value>rm1,rm2</value>
  </property>
  <property>
    <name>yarn.resourcemanager.hostname.rm1</name>
    <value>$DATA_NODE3</value>
  </property>
  <property>
    <name>yarn.resourcemanager.hostname.rm2</name>
    <value>$DATA_NODE4</value>
  </property>
</configuration>

EOF

	### core-site.xml config
cat > $path_conf/core-site.xml <<EOF
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
<configuration>
  <property>
    <name>fs.defaultFS</name>
    <value>hdfs://$NODE_ID:9000</value>
  </property>
  <property>
    <name>fs.defaultFS</name>
    <value>hdfs://mycluster</value>
  </property>
  <property>
    <name>ha.zookeeper.quorum</name>
    <value>$DATA_NODE2:2181,$DATA_NODE3:2181,$DATA_NODE4:2181</value>
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
    <value>$DATA_NODE2:50090</value>
  </property>
  <property>
    <name>dfs.namenode.checkpoint.dir</name>
    <value>/var/bigdata/hadoop/local/dfs/secondary</value>
  </property>

 <!-- HA配置开始 -->
 <!-- 以下是一对多,逻辑到物理节点的映射 -->
  <property>
    <name>dfs.nameservices</name>
    <value>mycluster</value>
  </property>
  <property>
    <name>dfs.ha.namenodes.mycluster</name>
    <value>nn1,nn2</value>
    </property>
  <property>
    <name>dfs.namenode.rpc-address.mycluster.nn1</name>
    <value>$NODE_ID:8020</value>
  </property>
  <property>
    <name>dfs.namenode.rpc-address.mycluster.nn2</name>
    <value>$DATA_NODE2:8020</value>
  </property>
  <property>
    <name>dfs.namenode.http-address.mycluster.nn1</name>
    <value>$NODE_ID:50070</value>
  </property>
  <property>
    <name>dfs.namenode.http-address.mycluster.nn2</name>
    <value>$DATA_NODE2:50070</value>
  </property>

  <!-- 以下是JN在哪里启动,数据存那个磁盘 -->
  <property>
    <name>dfs.namenode.shared.edits.dir</name>
    <value>qjournal://$NODE_ID:8485;$DATA_NODE2:8485;$DATA_NODE3:8485/mycluster</value>
  </property>
  <property>
    <name>dfs.journalnode.edits.dir</name>
    <value>/var/bigdata/hadoop/ha/dfs/jn</value>
  </property>
  <!-- HA角色切换的代理类和实现方法,我们用的ssh免密 -->
  <property>
    <name>dfs.client.failover.proxy.provider.mycluster</name>
    <value>org.apache.hadoop.hdfs.server.namenode.ha.ConfiguredFailoverProxyProvider</value>
  </property>
  <property>
    <name>dfs.ha.fencing.methods</name>
    <value>sshfence</value>
  </property>
  <property>
    <name>dfs.ha.fencing.ssh.private-key-files</name>
    <value>/root/.ssh/id_dsa</value>
  </property>

  <!-- 开启自动化:启动zkfc -->
  <property>
    <name>dfs.ha.automatic-failover.enabled</name>
    <value>true</value>
  </property>
  <!-- HA配置结束 -->
</configuration>


EOF
	

}

function install_cluster()
{
	### mkdir
    ssh $DATA_NODE2 "mkdir $INSTALL_PATH -p"	
    ssh $DATA_NODE3 "mkdir $INSTALL_PATH -p"	
    ssh $DATA_NODE4 "mkdir $INSTALL_PATH -p"

	### scp	
    cd $INSTALL_PATH
    scp -r $TARGET_PATH $DATA_NODE2:`pwd`
    scp -r $TARGET_PATH $DATA_NODE3:`pwd`
    scp -r $TARGET_PATH $DATA_NODE4:`pwd`

	### scp && source evn
    scp -r /etc/profile $DATA_NODE2:/etc
    scp -r /etc/profile $DATA_NODE3:/etc
    scp -r /etc/profile $DATA_NODE4:/etc
    ssh $DATA_NODE2 "source /etc/profile"	
    ssh $DATA_NODE3 "source /etc/profile"	
    ssh $DATA_NODE4 "source /etc/profile"

	### start,you should follow the order of command execution
	echo
	echo "need zookeeper!!!"
	echo
	echo "you should follow the order of command execution!!!"
    echo
	echo "1-source profile ..."
	echo "source /etc/profile"
	echo "2-start namenode(node01 node02 node03 all need to be activated!!!)..."
	echo "每台配置了JN的机器都需要执行以启动,否则会出现connection-refused 8485"
	echo "hadoop-daemon.sh start journalnode"
	echo "3-format hdfs namenode,仅搭建集群时操作一次(choose node01)..."
	echo "hdfs namenode -format"
	echo "4-启动格式化好的服务器的namenode(choose node01)..."
	echo "hadoop-daemon.sh start namenode"
	echo "5-启动同步的namenode(choose node02)..."
	echo "hdfs namenode -bootstrapStandby"
	echo "6-格式化zk,仅搭建集群时操作一次(choose node01)..."
	echo "hdfs zkfc -formatZK"
	echo "7-start hdfs cluster 启动hdfs集群..."
	echo "start-dfs.sh"
	echo "8-start yarn cluster 启动yarn集群..."
	echo "start-yarn.sh"
	echo "9-start resourcemanager 启动资源管理器...(choose node03 node04)"
	echo "yarn-daemon.sh start resourcemanager"
	echo "注意hdfs格式化失败,需要清理dfs.datanode.data.dir配置对应的目录中的current文件夹,否则后续datanode会启动失败"
	echo "DataStreamer Exception 0 nodes, 先stop-dfs.sh, 再清理dfs.datanode.data.dir配置的目录,再start-dfs.sh"
	echo "yarn-daemon.sh start resourcemanager"
	echo "Accessing HDFS through browser"
	echo "http://$NODE_ID:50070"
	echo "Accessing yarn through browser"
	echo "http://$DATA_NODE3:8088"
	echo "http://$DATA_NODE4:8088"
	echo
}

 
function main()
{
	### Execute as needed
	check_jdk
	check_package
    install_info
	install_package
	install_cluster
}
 
# Execute main method 
main
# END


#测试搭建情况
#创建hdfs目录
#hdfs dfs -mkdir -p /data/wc/input
#上传文件
#for i in `seq 100000`;do  echo "hello hadoop $i"  >>  data.txt  ;done
#hdfs dfs -D dfs.blocksize=1048576  -put data.txt  /data/wc/input
#使用官方jar测试mapreduce
#cd $HADOOP_HOME
#cd share/hadoop/mapreduce
#执行mapreduce任务
#hadoop jar hadoop-mapreduce-examples-2.6.5.jar wordcount /data/wc/input /data/wc/output
#查看执行结果
#hdfs dfs -ls /data/wc/output
#查看标志成功的文件 /data/wc/output/_SUCCESS
#hdfs dfs -cat  /data/wc/output/part-r-00000
#hdfs dfs -get  /data/wc/output/part-r-00000  ./
#删除output目录
#hdfs dfs -rm -r /data/wc/output
#页面查看(本地需配置C:\Windows\System32\drivers\etc\hosts) 
#http://node01:50070/explorer.html#/data/wc
#测试

