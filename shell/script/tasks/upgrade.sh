#!/bin/bash
. $AUTODEPLOY_HOME/script/tasks/include.sh
export APP_HOME="/home/robot/autoDeploy"
log_s "update code and build"

cd /home/robot/autoDeploy/robot_src/monkeyKing
git pull
mvn clean compile package dependency:copy-dependencies

log_s "build ok, I'm leaving now,and see you soon!"
sleep 3
ps -ef|grep "monkey.Launcher" |grep -v grep|awk '{print $2}'|xargs kill -9


log_s "delete current"
rm -f $APP_HOME/bin/lib/*.jar
rm -rf $APP_HOME/conf/
rm -rf $APP_HOME/script
rm -rf $APP_HOME/bin/classes



cd $APP_HOME
mkdir conf

cp -f $APP_HOME/robot_src/monkeyKing/target/dependency/*.jar $APP_HOME/bin/lib/
cp -f $APP_HOME/robot_src/monkeyKing/src/main/resources/*  $APP_HOME/conf/
cp -rf $APP_HOME/robot_src/monkeyKing/src/main/script $APP_HOME/script
cp -rf $APP_HOME/robot_src/monkeyKing/target/classes  $APP_HOME/bin/classes

rm -f $APP_HOME/bin/classes/applicationContext.xml
rm -f $APP_HOME/bin/classes/config.properties
rm -f $APP_HOME/bin/classes/log4j_config.xml

log_s "start robot"
$APP_HOME/bin/start.sh

log_s "chmod of task shells"
cd $APP_HOME/script/tasks

for task_sh in `ls`
do
  chmod +x $task_sh

done