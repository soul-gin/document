#!/bin/bash

###############################################
#
#   GIN INSTALL JDK ENV
#	将 sh,jdk 上传至linux自己存放软件的目录(例:softwares)
#	再配置 jdk_install_path 即可
#   注意: 确认 ls -l|awk '{print$9} 获取的是文件名
#	
#	Upload SH and JDK to the directory where Linux stores the software(for example, softwares)
#	Then configure JDK_Install_Path
#	Note: make sure ` ls -l|awk'{print$9}' ` gets the filename
#
###############################################
jdk_install_path="/usr/local"
# jdk_package_name 与 jdk_unzip_dir 为全局变量初始值,后续会被命令替换,可不配
# jdk_package_name and jdk_unzip_dir are the initial values of global variables. 
# They will be replaced by commands later. They need not configured
jdk_package_name="jdk-8u191-linux-x64.tar.gz"
jdk_unzip_dir="jdk1.8.0_191"
###############################################
#
#	remove_openjdk
#	check_package
#	install_jdk
#	test_jdk
#
###############################################

function remove_openjdk()
{
# remove openjdk if exists.  
for i in $(rpm -qa | grep openjdk | grep -v grep)  
do  
  echo "Deleting openjdk rpm -> "$i  
  rpm -e --nodeps $i  
done  

# check remove  
if [[ ! -z $(rpm -qa | grep openjdk | grep -v grep) ]];  
then
  echo "-->Failed to remove the openjdk."
  exit
else 
  echo "-->Successed to remove the openjdk." 
fi
} 

function check_package()
{
	### check jdk_install_path exists
	if [ ! -d "${jdk_install_path}" ];
	then
		echo "${jdk_install_path} not exit, mkdir"
		mkdir -p "${jdk_install_path}"
	else
		echo "${jdk_install_path} is exit"
	fi
	### get jdk.tar package name from current file
    jdk_package_name=`ls | grep jdk | grep .tar.gz`
	
	### check package
    if [ ! -f "${jdk_package_name}" ];
    then
		echo "you need jdk package!"
        exit
    fi    
 
    ### check unzip tmp dir
	jdk_unzip_dir=`ls -l | grep '^d' |grep jdk |awk '{print$9}'`
	if [ -d "${jdk_unzip_dir}" ];
    then
		echo "${jdk_unzip_dir} is exit, rm unzip path"
        rm -rf "${jdk_unzip_dir}"
    fi
	
	
 
}
################################################
#
#   install jdk
#
#################################################
function install_jdk()
{
	### unzip
	tar -zxf "${jdk_package_name}"
	### get file name
	jdk_unzip_dir=`ls -l | grep '^d' |grep jdk |awk '{print$9}'`
	### move file to install path
	echo "jdk_unzip_dir=${jdk_unzip_dir}, jdk_install_path=${jdk_install_path}"
	if [ -d "${jdk_install_path}/${jdk_unzip_dir}" ];
    then
		echo "${jdk_install_path}/${jdk_unzip_dir} is exit, rm install path"
        rm -rf "${jdk_install_path}/${jdk_unzip_dir}"
    fi
    mv "${jdk_unzip_dir}" "${jdk_install_path}"/
    
	### apend settings
    echo "# java environment begin" >> /etc/profile
    echo "JAVA_HOME=${jdk_install_path}/${jdk_unzip_dir}" >>/etc/profile
    echo "CLASSPATH=\${JAVA_HOME}/lib" >>/etc/profile
    echo "PATH=\$PATH:\${JAVA_HOME}/bin" >>/etc/profile
    echo "export PATH JAVA_HOME CLASSPATH" >>/etc/profile
    echo "# java environment end" >>/etc/profile
	### source
	source /etc/profile
	### append user settings like /home/${USER}/.bash_profile
}

function test_jdk()
{
# 5. Test JDK evironment  
  if [ ! -d $JAVA_HOME ];
  then 
    echo "-->Failed to install JDK"  
  else  
    echo "-->JDK has been successed installed."  
    echo "java -version"  
    java -version  
    echo "ls \$JAVA_HOME"
    ls $JAVA_HOME
  fi
}  
 
function main()
{
	### Execute as needed
	remove_openjdk
    check_package
    install_jdk
	test_jdk
}
 
# Execute main method 
main
# END



