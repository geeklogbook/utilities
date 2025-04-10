## 1. Levantar el docker compose

```
docker compose up --build
```

## 2. Acceder al contenedor hadoop-master

```
docker exec -it hadoop-master bash
```

## 3. Descarga archivo y lo envia al cluster

#### 3.1 Un archivo txt de un libro

```
wget https://raw.githubusercontent.com/uracilo/testdata/master/odisea.txt
```

#### 3.2 Crear un directorio

```
mkdir input
```

#### 3.3 Crear un archivo tipo tar.gz

```
tar -czvf input/odisea.tar.gz odisea.txt
```

- c: Generar archivo
- z: Comprimir con gzip.
- v: Progreso del proceso.
- f: Especificar nombre del archivo.

#### 3.4 Revisar los tamaños de nuestros archivos

```
ls -flarts input
```

Listar los diferentes archivos llamados odisea y ver su tamaño

```
find /root -name "odisea*" -exec stat -c "%n %s bytes" {} \;
```
## 4 Usando HDFS y DFS
#### 4.1 Crear y mover directorio input al DFS de HADOOP

```
hdfs dfs -mkdir -p test
hdfs dfs -put input
```

#### 4.2 Revisar nuestro input directorio en HADOOP

```
hdfs dfs -ls input
```

#### 4.3 Opcional - Leer las primeras lineas de nuestro archivo en HADOOP 

```
hdfs dfs -cat  input/odisea.tar.gz | zcat | tail -n 20
```

#### 4.4. Opcional -Eliminar el archivo en HADOOP

```
hdfs dfs -rm -f /user/rawdata/example/odisea.tar.gz
```

## 5. Ejecutar un trabajo en HADOOP
### 5.1 Script que ejecuta el Job con la funcion Word Count

```
hadoop jar $HADOOP_HOME/share/hadoop/mapreduce/sources/hadoop-mapreduce-examples-2.7.2-sources.jar org.apache.hadoop.examples.WordCount input output
```

## 6. Resultados del trabajo (JOB) en HADOOP
### 6.1 Archivos dentro del cluster

```
hdfs dfs -ls
```

### 6.2 Archivos en la carpeta output

```
hdfs dfs -ls output/
```

### 6.3 Registros

```
hdfs dfs -cat output/part-r-00000
```

# 7 - Opcional: Limpiando odisea

```
cat odisea.txt | tr '[:upper:]' '[:lower:]' | tr -d '[:punct:]' | tr -s ' ' > odisea_clean.txt
```

```
hdfs dfs -mkdir -p input
hdfs dfs -put odisea_clean.txt input/
```

```
hadoop jar $HADOOP_HOME/share/hadoop/mapreduce/sources/hadoop-mapreduce-examples-2.7.2-sources.jar org.apache.hadoop.examples.WordCount input output_clean
```

```
hdfs dfs -cat output/part-r-00000 | head -20
```

# 8 - Opcional: Procesar Reviews

### 8.1 Agrego reviews
```
cat > reviews.txt
```
Pego las reviews. Enter. CTRL + C

### 8.2 Agrego las reviews a hdfs
```
hdfs dfs -put reviews.txt input/
```
```
hdfs dfs -ls input/
```

### 8.3 Corro el Job
```
hadoop jar $HADOOP_HOME/share/hadoop/mapreduce/sources/hadoop-mapreduce-examples-2.7.2-sources.jar org.apache.hadoop.examples.WordCount input output_reviews
```

### 8.4 Miro el ejemplo
```
hdfs dfs -cat output_reviews/part-r-00000 | sort -k2,2nr | head -20
```

## 9 - Opcional cuento solo las estrellas
```
cat reviews.txt | grep -oE '[1-5] estrellas' | awk '{print $1}' > stars.txt
```

```
mkdir input_stars
hdfs dfs -put stars.txt input_stars
```

```
hadoop jar $HADOOP_HOME/share/hadoop/mapreduce/sources/hadoop-mapreduce-examples-2.7.2-sources.jar org.apache.hadoop.examples.WordCount input_stars output_stars
```

```
hdfs dfs -cat output_stars/part-r-00000 | sort -k2,2nr | head -20
```

## 10 - Opcional cuento quitando las preposiciones y conectores

```
cat reviews.txt | sed 's/[^a-zA-Z0-9 ]//g' | tr ' ' '\n' | grep -vw -E '(de|es|con|un|el|la|lo|en|y|muy|pero|que|no|si|al|por|para|mi)' > clean_reviews.txt
```