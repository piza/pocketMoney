#!/bin/bash

export  AUTODEPLOY_HOME=`pwd`
. $AUTODEPLOY_HOME/script/tasks/include.sh
[ $? -eq 0 ] || fail "env setup faild,check $AUTODEPLOY_HOME/include.sh please."

export  GIT_REPO="/home/robot/code_src/yijian" || check_dir $GIT_REPO
export  GIT_PATH="git@gitlab.01cun.com:jianshen/yijian.git"

cd $GIT_REPO
#git reset --hard origin/master >> $AUTODEPLOY_LOG_FILE
git pull $GIT_PATH master >> $AUTODEPLOY_LOG_FILE
log_s `git status`
[ $? -eq 0 ] || fail "GIT updateCode faild: $?"

log_s "GIT updateCode is completed"