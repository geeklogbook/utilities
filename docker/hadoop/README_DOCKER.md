### 1. Levantar el docker compose

```
docker compose up --build
```

### 2. Acceder al contenedor hadoop-master

```
docker exec -it hadoop-namenode bash
```

### 3. Iniciar hadoop

```
./start-hadoop.sh
```

### 4. Descarga archivo y lo envia al cluster

#### 4.1 Un archivo txt de un libro

```
wget https://raw.githubusercontent.com/uracilo/testdata/master/odisea.txt
```

#### 4.2 Crear un directorio

```
mkdir input
```

#### 4.3 Crear un archivo tipo tar.gz

```
tar -czvf input/odisea.tar.gz odisea.txt
```

-c: Generar archivo
-z: Comprimir con gzip.
-v: Progreso del proceso.
-f: Especificar nombre del archivo.

#### 4.4 Revisar los tamaños de nuestros archivos

```
ls -flarts input
```

Listar los diferentes archivos llamados odisea y ver su tamaño

```
find /root -name "odisea*" -exec stat -c "%n %s bytes" {} \;
```
#### 4.5 Crear y mover directorio input al DFS de HADOOP

```
hdfs dfs -mkdir -p test
hdfs dfs -put input
```

##### 4.6 Revisar nuestro input directorio en HADOOP

```
hdfs dfs -ls input
```

#### 4.7 Opcional - Leer las primeras lineas de nuestro archivo en HADOOP 

```
hdfs dfs -cat  input/odisea.tar.gz | zcat | tail -n 20
```

#### 4.8. Opctional -Eliminar el archivo en HADOOP

```
hdfs dfs -rm -f /user/rawdata/example/odisea.tar.gz
```

### 5. Ejecutar un trabajo en HADOOP

```
hadoop jar $HADOOP_HOME/share/hadoop/mapreduce/sources/hadoop-mapreduce-examples-2.7.2-sources.jar org.apache.hadoop.examples.WordCount input output
```

### 6. Ver el resultado del trabajo en HADOOP

```
hdfs dfs -cat output/part-r-00000
```

Ver los directorios dentro del cluster:

```
hdfs dfs -ls
```

ver los archivos generados en la carpeta output:

```
hdfs dfs -ls output/
```
