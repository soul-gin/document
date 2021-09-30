#!/bin/bash

# 查看安装包存放路径
path_softwares=/home/admin/softwares/
path_middlewares=/home/admin/mw/
name_aerospike=aerospike-server-community-4.3.1.4-el7.tgz
if [ ! -d ${path_softwares} ];then
	echo "安装包文件夹"${path_softwares}"不存在,请确认"
	exit 1;
else
	echo "文件夹存在,切换目录"
	cd ${path_softwares}
fi

# 查看安装包
path_aerospike=$(find ${path_softwares} -name ${name_aerospike})

if [ ! $path_aerospike ];then
    echo "can not find aerospike ..."
	exit 1;
else
    echo "find aerospike ..."
fi

# 创建安装目录
mkdir -p ${path_middlewares}

# 解压
echo "begin tar aerospike"
tar -zxvf ${path_softwares}${name_aerospike} -C ${path_middlewares}
cd ${path_middlewares};
mv ${path_middlewares}aerospike-server-community-4.3.1.4-el7 ${path_middlewares}aerospike;
echo "end tar aerospike"

# 创建数据,日志目录
mkdir -p ${path_middlewares}aerospike/{data,logs} 

cd ${path_middlewares}
${path_middlewares}aerospike/asinstall

yum list installed | grep aerospike-tools

chmod 777 /etc/aerospike/aerospike.conf

cat > /etc/aerospike/aerospike.conf<<'EOF'

# Aerospike database configuration file for use with systemd.
service {
		# 副本计数自动减少到1的节点数量
		paxos-single-replica-limit 1
		proto-fd-max 15000
		
		# 可选配置 begin
		# 服务线程
		#service-threads 32
		# 事务队列
		#transaction-queues 32
		# 事务线程每队列
		#transaction-threads-per-queue 32
		# 批处理索引线程
		#batch-index-threads 32
		#batch-max-requests 200000
		# 可选配置 end
		
	}
	logging {
		# 日志文件路径,必须是绝对路径(目录需要提前创建,替换掉console)
		file /home/admin/mw/aerospike/logs/aerospike.log {
		context any info
	}
}
network {
	service {
		address any
		port 3000
	}
	heartbeat {
		mode mesh
		# 本机IP
		address td01
		# 端口号
		port 3002 
		# 可以使用域名(hostname)例: mesh-seed-address-port jlcw01 3002
		mesh-seed-address-port td01 3002
		# 集群模式下其他节点信息(集群才需要配置)
		#mesh-seed-address-port 10.57.17.185 3002
		#mesh-seed-address-port 10.57.17.186 3002
		interval 150
		timeout 10
	}
	fabric {
		port 3001
	}
	info {
		port 3003
	}
}

# 注意:集群内的每个节点有一个配置文件aerospike.conf
# 每个节点配置文件中的namespace配置参数必须一致
# too many namespaces (max is 2) 最多两个namespace
namespace ns1 {
	# 复制因子,单机环境可配置为1(无需复制),也可用2(不会报错)
	# 副本越多可靠性越高,写请求会急剧增大,不建议超过3.
	# 实践中,大部分部署使用的数据因子为2(一个主数据和一个副本)
	# 无复制数据需要设置复制因子为1(replication factor = 1)
	replication-factor 2
	# 内存大小
	memory-size 1G
	# 30d 表示30天过期,0表示不过期
	default-ttl 0
	storage-engine device {
		file /home/admin/mw/aerospike/data/ns1.dat
		# 物理存储文件大小(应至少和内存大小一致)
		filesize 2G
		data-in-memory true
	}
}

#namespace bar {
	 # 复制因子
#    replication-factor 2
#    memory-size 4G
#    default-ttl 30d
#    storage-engine memory
#}

EOF








