#!/bin/bash

export  AUTODEPLOY_HOME=`pwd`
. $AUTODEPLOY_HOME/script/tasks/include.sh
[ $? -eq 0 ] || fail "env setup faild,check $AUTODEPLOY_HOME/include.sh please."

export  WORK_ROOT="/home/robot" || check_dir $GIT_REPO
export  TOMCAT_HOME="/home/robot/apache-tomcat-7.0.59"

log_s "deploy frontend"
cd $WORK_ROOT/frontend
rm -rf previous
mv -rf current previous

mkdir current
cd current
jar -xf $WORK_ROOT/code_src/yijian/frontend/target/frontend.war

log_s "deploy operate"
cd $WORK_ROOT/operate
rm -rf previous
mv -rf current previous
mkdir current
cd current
jar -xf $WORK_ROOT/code_src/yijian/operate/target/operate.war

log_s "stop tomcat"
cd $TOMCAT_HOME
bin/shutdown.sh

sleep 5

log_s "start tomcat"
bin/startup.sh

log_s "deploy successful"