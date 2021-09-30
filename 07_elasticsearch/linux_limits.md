### linux 系统参数调优

- 出现 Too many open files 问题(open files)
- 服务端出现  CLOSE-WAIT 问题(max user processes)
- es出现 max virtual memory areas vm.max_map_count [] is too low 问题(vm.max_map_count)

#### 查看目前系统已使用资源

查看系统状态

```shell
iostat
free -h
top
```



查看 open files 

```shell
lsof -n |awk '{print $2}'|sort|uniq -c |sort -nr|more
```

  结果展示: 第一列是打开的文件句柄数量, 第二行是进程号
    2762 1148
    2226 943
    1480 873



#### 使用命令查看系统限制

```shell
ulimit –a
```

open files 代表最大文件打开数,  max user processes代表最大进程数

open files								(-n) 65535

max user processes				 (-u) 8192



```shell
more /proc/sys/vm/max_map_count
# 或者
sysctl -a|grep vm.max_map_count
```

vm.max_map_count 代表虚拟内存区域(一个连续的虚拟地址空间区域)

vm.max_map_count = 65535



#### 根据需求临时修改

- root用户临时修改

  - 修改"最大文件打开数(open files)"

  ```shell
  ulimit -n 999999
  ```

  - 修改"最大进程数(max user processes)"

  ```shell
  ulimit -u 65535
  ```

  - 修改"VMA的数量(vm.max_map_count)"

  ```shell
  sysctl -w vm.max_map_count=655360
  ```

- 非root用户临时修改

  - 修改"最大文件打开数(open files)"

  ```shell
  sudo sh -c "ulimit -n 999999 && exec su $LOGNAME"
  ```

  - 修改"最大进程数(max user processes)"

  ```shell
  ulimit -u 65535
  ```

  - 修改"VMA的数量(vm.max_map_count)"

  ```shell
  sudo sysctl -w vm.max_map_count=655360
  ```



#### 根据需求永久修改(root用户或者sudo)
##### 前置环境准备

内核参数：单个进程可分配的最大文件句柄数。

```shell
cat /proc/sys/fs/nr_open
```

内核参数：系统内核可分配的最大文件句柄数。

  ```shell
cat /proc/sys/fs/file-max
  ```

vi /etc/sysctl.conf 

```shell
fs.nr_open = 1000576
fs.file-max = 1248576
vm.max_map_count = 655360
```

需要通过sysctl -p生效(root用户 * 不生效,需要: 

```shell
sysctl -p
```



注意(sysctl.conf 中配置 与 limits.conf 中配置项关系) : 

**nr_open < file-max**

**soft nofile <= hard nofile < nr_open < file-max**

##### 后续配置

vi /etc/security/limits.conf

根据 limits.conf 中配置的实际情况,增加或修改

注意事项:

- soft需要小于或等于hard的值
- `/etc/security/limits.d/`目录里的文件配置项会覆盖`/etc/security/limits.conf`的配置项
- CentOS7版本`/etc/systemd/system.conf`也可能覆盖`/etc/security/limits.conf`的配置项

```shell
#
# begin
#

# * 代表针对所有用户
# soft nproc : 单个用户可用的最大进程数量(max user processes),超过会警告
# hard nproc : 单个用户可用的最大进程数量,超过会报错
# soft nofile : 可打开的文件描述符的最大数(open files),超过会警告
# hard nofile : 可打开的文件描述符的最大数,超过会报错

*   soft noproc   65535
*   hard noproc   65535
*   soft nofile   999999
*   hard nofile   999999

# 指定用户进行配置 begin 根据需要打开注释进行配置
# oracle   soft noproc   2047
# oracle   hard noproc   16384
# oracle   soft nofile   10240
# oracle   hard nofile   65535
# 指定用户进行配置 end

#
# end
#
```



##### 检查配置,防止被覆盖

不同系统版本目录相同,文件名可能不同

```shell
cd /etc/security/limits.d/
vi 20-nproc.conf
```

注意下列配置是否和需求( /etc/security/limits.conf )一致

```shell
*          soft    nproc     65535
root       soft    nproc     65535
```

CentOS 7 使用systemd替换了SysV的init系统，在`/etc/systemd`目录下有一个系统的默认管理配置，这里有登陆、日志、服务、系统等。

避免`/etc/systemd/system.conf`覆盖之前的配置

快速修改：

```shell
sed -i '/^#DefaultLimitNOFILE=/aDefaultLimitNOFILE=999999' /etc/systemd/system.conf 
sed -i '/^#DefaultLimitNPROC=/aDefaultLimitNPROC=65535' /etc/systemd/system.conf
```

查看修改后值:

```shell
egrep -v "^#"  /etc/systemd/system.conf
```

重启服务器生效



#### 其他可选优化项

```shell
vi /etc/sysctl.conf 
```

添加下列配置

```shell
#消息队列最大值
kernel.msgmnb = 65536
#设置消息的大小,单位: 字节
kernel.msgmax = 65536
#可以使用的信号量
kernel.sem = 250 256000 32 15360
kernel.watchdog_thresh = 30
kernel.shmall = 5831170
kernel.shmmax = 11942236160
kernel.shmmni = 4096

# DDoS, CC 和 SYN攻击 begin
#禁用-0; 启用-1; 表示是否开启SYN Cookies,当SYN等待队列溢出时,启用cookies来处理,防范少量的SYN攻击
net.ipv4.tcp_synccookies = 0
#禁用-0; 启用-1; 表示是否允许TIME_WAIT sockets重新用于新的TCP连接
net.ipv4.tcp_tw_reuse = 1
#禁用-0; 启用-1; 表示是否允许TIME_WAIT sockets快速回收以便利用
net.ipv4.tcp_tw_recycle = 0
#TCP三次请求的fin状态超时时间,单位: 秒
net.ipv4.tcp_fin_timeout = 30
# DDoS, CC 和 SYN攻击 end

# TCP SYN队列长度(可容纳网络连接数)
net.ipv4.tcp_max_syn_backlog = 8192
# TCP TIME_WAIT最大数量
net.ipv4.tcp_max_tw_buckets = 8192
# TCP发送keepalive频度,单位: 秒
net.ipv4.tcp_keepalive_time = 1800
# TCP发送探测包间隔,单位: 秒
net.ipv4.tcp_keepalive_intvl = 60
# TCP对方无应答,探测包发送次数
net.ipv4.tcp_keepalive_probes = 10
# TCP失败重传次数
net.ipv4.tcp_retries2 = 8

# 本地端口范围
net.ipv4.ip_local_port_range = 30000 65000

# 禁用-0; 启用-1; 拒绝接受广播风暴或者smurf
net.ipv4.icmp_echo_ignore_broadcasts = 1
# 禁用-0; 启用-1; 拒绝接受广播风暴或者smurf
net.ipv4.icmp_ignore_bogus_error_responses = 1
# 禁用-0; 启用-1; 是否开启记录欺骗.源路由和重定向包
net.ipv4.icmp_ignore_bogus_error_responses = 1

# 接受数据缓存区范围
net.ipv4.tcp_rmem = 4096 87380 16777216
net.ipv4.tcp_wmem = 4096 87380 16777216
net.ipv4.tcp_mem = 189033 1048576 2097152
#最大孤儿套接字个数
net.ipv4.tcp_max_orphans = 327680

# socket缓冲区默认大小
net.core.rmem_default = 262144
net.core.wmem_default = 262144
# socket缓冲区最大大小
net.core.rmem_default = 1048576
net.core.wmem_default = 1048576
# 输入队列最大报文数
net.core.netdev_max_backlog = 262144


```

