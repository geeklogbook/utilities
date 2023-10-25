-- CULTIVO
IF OBJECT_ID('src.tipo_cultivo_dim', 'U') IS NOT NULL DROP TABLE src.tipo_cultivo_dim; 
CREATE TABLE src.TipoCultivo_dim (
    id INT IDENTITY(1,1) PRIMARY KEY,
    cultivo_nombre VARCHAR(50)
);

INSERT INTO src.tipo_cultivo_dim (cultivo_nombre)
SELECT DISTINCT cultivo_nombre 
FROM ##TempAllRawData;

-- AÑOS
IF OBJECT_ID('src.anio_dim', 'U') IS NOT NULL DROP TABLE src.anio_dim; 
CREATE TABLE src.anio_dim (
    id INT IDENTITY(1,1) PRIMARY KEY,
    anio VARCHAR(50)
);

INSERT INTO src.anio_dim (anio)
SELECT DISTINCT anio 
FROM ##TempAllRawData;

-- PROVINCIA
-- Nota: No se puede utilizar los Ids provistos ya que están duplicados
IF OBJECT_ID('src.provincia_dim', 'U') IS NOT NULL DROP TABLE src.provincia_dim; 
CREATE TABLE src.provincia_dim (
    id INT IDENTITY(1,1) PRIMARY KEY,
    provincia_nombre VARCHAR(50)
);

INSERT INTO src.provincia_dim (provincia_nombre)
SELECT DISTINCT provincia_nombre 
FROM ##TempAllRawData;

-- DEPARTAMENTO
-- Nota: No se puede utilizar los Ids provistos ya que están duplicados
IF OBJECT_ID('src.departamento_dim', 'U') IS NOT NULL DROP TABLE src.departamento_dim; 
CREATE TABLE src.departamento_dim (
    id INT IDENTITY(1,1) PRIMARY KEY,
    departamento_nombre VARCHAR(50)
);

INSERT INTO src.departamento_dim (departamento_nombre)
SELECT DISTINCT departamento_nombre 
FROM ##TempAllRawData;