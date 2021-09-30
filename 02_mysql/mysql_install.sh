#!/bin/bash


### install_env

 
### add group.user mysql
groupadd mysql
useradd -r -g mysql -s /bin/nologin mysql

mkdir -p /home/mysql
tar -zxf mysql-5.7.23-linux-glibc2.12-x86_64.tar.gz -C /home/mysql
mv /home/mysql/mysql-5.7.23-linux-glibc2.12-x86_64 /home/mysql/mysql-5.7.23
mkdir -p /home/mysql/mysql-5.7.23/data
mkdir -p /home/mysql/mysql-5.7.23/tmp
touch /home/mysql/mysql-5.7.23/tmp/mysql.log
cp /home/mysql/mysql-5.7.23/support-files/mysql.server /etc/init.d/mysqld
chmod 777 /home/mysql/mysql-5.7.23/data -R
chmod 777 /home/mysql/mysql-5.7.23/tmp -R



chown -R mysql:mysql /home/mysql


cat > /etc/my.cnf <<EOF
#
# begin my.cfg
#

[mysqld]
basedir = /home/mysql/mysql-5.7.23
datadir = /home/mysql/mysql-5.7.23/data
tmpdir = /home/mysql/mysql-5.7.23/tmp
port = 3306
# This value is unique for different machines. It is recommended to increase from 1.
server_id = 1
socket = /home/mysql/mysql-5.7.23/tmp/mysql.sock
log-error = /home/mysql/mysql-5.7.23/tmp/mysql.error
pid-file = /home/mysql/mysql-5.7.23/tmp/mysql.pid
character_set_server = utf8
collation-server = utf8_general_ci
lower_case_table_names = 1
# 
max_allowed_packet = 300M
max_connections = 1000
sql_mode=NO_ENGINE_SUBSTITUTION,STRICT_TRANS_TABLES
# log-bin used in master-slaves model
log-bin=master-bin
expire_logs_days=3
# deal remote connect error
# skip-name-resolve

[client]
socket = /home/mysql/mysql-5.7.23/tmp/mysql.sock
default-character-set=utf8

[mysql]
default-character-set=utf8

#
# end file
#
EOF
















