Write-Output "\n"

& "$env:HADOOP_HOME\sbin\start-dfs.sh"

Write-Output "\n"

& "$env:HADOOP_HOME\sbin\start-yarn.sh"

Write-Output "\n"
