#!/bin/bash

export  AUTODEPLOY_LOG_FILE="/home/peter/autoDeploy/logs/log4deploy.log"
[ -f $AUTODEPLOY_LOG_FILE ] && mv "$AUTODEPLOY_LOG_FILE" "$AUTODEPLOY_LOG_FILE.0"

function log_s()
{
	echo -e "`date '+%H:%M:%S'-`$1"|tee -a  $AUTODEPLOY_LOG_FILE
}
function fail()
{
    log_s "$1"
	log_s "operation faild, check the log and try again please."
	exit -1
}

function check_dir()
{
    [ -d $1 ] || fail "Directory $1 doesn't exist!";
}


export  GIT_REPO="/home/peter/code_src/pocketMoney" || check_dir $GIT_REPO
export  GIT_PATH="git@github.com:piza/pocketMoney.git"
export  TOMCAT_HOME="/home/peter/apache-tomcat-8.0.23"
export  PROJECT_DOC_BASE="/home/peter/pocketMoney"
export  PROJECT_NAME="pocketMoney"
