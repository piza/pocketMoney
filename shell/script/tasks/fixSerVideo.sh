#!/bin/bash

for badFile in `find . -name "*.flv.ser"`
do
     videoFile=${badFile%.*}
    if [ -f "$videoFile" ];then
       mv $videoFile ./tempVideo.flv
       cat ./tempVideo.flv $badFile > $videoFile
       rm -f ./tempVideo.flv
    else
       cat $badFile > $videoFile
    fi
done