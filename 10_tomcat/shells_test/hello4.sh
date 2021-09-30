


#!/bin/bash
# read命令用于从控制台读取输入数据, 并赋值给 NAME 变量
read -p "please input your name:" NAME
# printf '%s\n' $NAME 根据输入信息打印内容
# 注意 [ ] 两边都需要预留空格, = 两边也需要预留空格, = 这里表示的不是赋值而是判断
if [ $NAME = root ]
	then
		echo "hello ${NAME}, welcome !"
	elif [ $NAME = gin ]
	then
		echo "hello ${NAME}, welcome !"
	else
		echo "Get out Please!"
fi



