#!/bin/bash

OLD_PASSWORD=$1
NEW_PASSWORD=$2
MYSQL_USER=tongdun


function install_info(){
  ### execute shell param confirm
  echo
  echo "OLD_PASSWORD: ${OLD_PASSWORD}"
  echo "NEW_PASSWORD: ${NEW_PASSWORD}"
  echo "MYSQL_USER: ${MYSQL_USER}"
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
###invoke function
install_info


###get password & publicKey
function check_passwd()
{
  if [ -z $OLD_PASSWORD ];
  then
    echo "OLD_PASSWORD not set"
    exit 1
  else
    echo "OLD_PASSWORD set: $OLD_PASSWORD" > old.tmp
  fi

  if [ -z $NEW_PASSWORD ];
  then
    echo "NEW_PASSWORD not set"
    exit 1
  else
    echo "NEW_PASSWORD set: $NEW_PASSWORD" > new.tmp
  fi

}
###invoke function
check_passwd


function alter_mysql_passwd()
{

mysql -u"$MYSQL_USER" -p"$OLD_PASSWORD" << EOF
GRANT ALL PRIVILEGES ON *.* TO "$MYSQL_USER"@"%" IDENTIFIED BY "$NEW_PASSWORD" WITH GRANT OPTION;
flush privileges;
EOF

}

###invoke function
alter_mysql_passwd

echo "alter_mysql_passwd completed"
