#!/bin/bash

echo  -e  "restart out_access_service ..."
nohup sh ./out_access_service >/dev/null 2>error_log.txt &
