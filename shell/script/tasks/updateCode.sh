#!/bin/bash

basepath=$(cd `dirname $0`; pwd)
. $basepath/include.sh
[ $? -eq 0 ] || fail "env setup faild,check include.sh please."

cd $GIT_REPO
#git reset --hard origin/master >> $AUTODEPLOY_LOG_FILE
git pull $GIT_PATH master >> $AUTODEPLOY_LOG_FILE
log_s `git status`
[ $? -eq 0 ] || fail "GIT updateCode faild: $?"

log_s "GIT updateCode is completed"