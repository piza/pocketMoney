#!/bin/bash

basepath=$(cd `dirname $0`; pwd)
. $basepath/include.sh
[ $? -eq 0 ] || fail "env setup faild,check include.sh please."

cd $GIT_REPO
mvn clean compile package install

log_s "GIT updateCode is completed"