#!/bin/bash

#正常输出/错误输出 均输出到null
#nohup ./go_server_data.sh >/dev/null 2>&1 &

#正常输出 输出到null, 错误输出 输出至error_log.txt
nohup ./go_server_data.sh >/dev/null 2>error_log.txt &
