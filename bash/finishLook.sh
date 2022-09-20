
#!/bin/bash

s="lorem.ipsum.cesptu.obispun.til"
ch='n'

echo $s | awk -F $ch '{print $2}'