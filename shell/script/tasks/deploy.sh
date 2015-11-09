#!/bin/bash

basepath=$(cd `dirname $0`; pwd)
. $basepath/include.sh
[ $? -eq 0 ] || fail "env setup faild,check include.sh please."


log_s "deploy $PROJECT_NAME"
cd $PROJECT_DOC_BASE
rm -rf previous
mv -rf current previous

mkdir current
cd current
jar -xf $GIT_REPO/target/$PROJECT_NAME.war


log_s "stop tomcat"
cd $TOMCAT_HOME
bin/shutdown.sh

sleep 5

log_s "start tomcat"
bin/startup.sh

log_s "deploy successful"