#!/bin/bash

###############################################
#
#   GIN INSTALL SECRET FREE ENV	
#	alter PASSWD and IPS
#
###############################################

#各用户登录密码需相同
#all user passwords need to be the same
PASSWD='123456'

#根据你的需要修改ips的过滤条件
#Modify the filtering conditions of IPS according to your needs
IPS=$(cat /etc/hosts |grep -v "::" | grep -v "127.0.0.1" | grep -Ev "^$|[#;]")
#or you can defined by ip, split by space
#IPS=(192.168.1.11 192.168.1.12 192.168.1.13)

function key_generate(){
    expect -c "set timeout -1;
        spawn ssh-keygen -t rsa;
        expect {
            {Enter file in which to save the key*} {send -- \r;exp_continue}
            {Enter passphrase*} {send -- \r;exp_continue}
            {Enter same passphrase again:} {send -- \r;exp_continue}
            {Overwrite (y/n)*} {send -- n\r;exp_continue}
            eof             {exit 0;}
    };"
}

function ssh_copy_id(){
    expect -c "set timeout -1;
        spawn ssh-copy-id -i $HOME/.ssh/id_rsa.pub root@$1;
            expect {
                {Are you sure you want to continue connecting *} {send -- yes\r;exp_continue;}
                {*password:} {send -- $2\r;exp_continue;}
                eof {exit 0;}
            };"
}

function scp_ssh_id(){
    for ip in $IPS
	do
		scp -r ~/.ssh $ip:~/
	done
}

main(){
	#install expect to avoid interaction
	yum -y install expect
	
	#ssh-keygen -t rsa 
	rm -rf ~/.ssh
	key_generate
	
	#ssh-copy-id udf_ip
	for ip in $IPS
	do
		ssh_copy_id $ip $PASSWD
	done
	
	#scp to other service
	scp_ssh_id
}

#execute
main





