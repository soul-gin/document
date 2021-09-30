#!/bin/bash
rpm -ivh ./clickhouse-*.rpm
echo "ln -s datadir /var/lib/clickhouse"
