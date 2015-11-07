#!/bin/bash
export APP_HOME=/home/robot/autoDeploy
lib="$APP_HOME/bin/lib"

class_path="$APP_HOME/conf:$APP_HOME/bin/classes"

for dir in `ls $lib`
do
    class_path="$lib/$dir:""$class_path"
done
echo class_path=$class_path
nohup java -cp $class_path monkey.Launcher &