# Número default de nodos
param (
    [int]$N = 3
)

# Iniciar el contenedor de hadoop-master
Write-Output "Start hadoop-master container..."
docker rm -f hadoop-master *> $null

docker run -itd `
    --net=hadoop `
    -p 50070:50070 `
    -p 8088:8088 `
    --name hadoop-master `
    --hostname hadoop-master `
    uracilo/hadoop *> $null

# Inicializar los contenedores esclavos
for ($i = 1; $i -lt $N; $i++) {
    Write-Output "Start hadoop-slave$i container..."
    docker rm -f hadoop-slave$i *> $null
    
    docker run -itd `
        --net=hadoop `
        --name hadoop-slave$i `
        --hostname hadoop-slave$i `
        uracilo/hadoop *> $null
}

# Ingresar a nuestro contenedor master
docker exec -it hadoop-master bash
