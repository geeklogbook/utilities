#!/bin/bash
#bc - l
x=$1
y=$2
t=$(echo "$x/$y " | bc -l | awk '{printf("%.2f \n",$1)}')
echo $t