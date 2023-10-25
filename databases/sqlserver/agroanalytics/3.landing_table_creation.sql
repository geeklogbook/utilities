BEGIN TRY
    DROP TABLE ##TempAllRawData;
END TRY
BEGIN CATCH
END CATCH;

WITH all_data AS (
    SELECT * FROM raw_data.avena_stg
    UNION
    SELECT * FROM raw_data.girasol_stg
    UNION
    SELECT * FROM raw_data.maiz_stg
    UNION
    SELECT * FROM raw_data.mijo_stg
    UNION
    SELECT * FROM raw_data.soja_stg
) 
SELECT * INTO ##TempAllRawData FROM all_data;

BEGIN TRY
    DROP TABLE raw_data.all_raw_tables;
END TRY
BEGIN CATCH
END CATCH;
CREATE TABLE raw_data.all_raw_tables (
	id INT IDENTITY(1,1) PRIMARY KEY,
	date_inserted DATETIME,
    cultivo_nombre VARCHAR(50),
    anio VARCHAR(50),
    provincia_nombre VARCHAR(50),
    departamento_nombre VARCHAR(50),
    superficie_sembrada_ha VARCHAR(50),
    superficie_cosechada_ha VARCHAR(50),
    produccion_tm VARCHAR(50),
    rendimiento_kgxha VARCHAR(50),
);
INSERT INTO raw_data.all_raw_tables 
SELECT GETDATE(),
	   cultivo_nombre,	
       anio,	
	   provincia_nombre,	
	   departamento_nombre,	
	   superficie_sembrada_ha,	
	   superficie_cosechada_ha,	
	   produccion_tm,	
	   rendimiento_kgxha 
FROM ##TempAllRawData;