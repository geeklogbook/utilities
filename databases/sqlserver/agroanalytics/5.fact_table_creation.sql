CREATE TABLE star.fact_table (
    anio_id INT,
    departamento_id INT,
    provincia_id INT,
    cultivo_id INT,
    superficie_sembrada_ha FLOAT,
    superficie_cosechada_ha FLOAT,
    produccion_tm FLOAT,
    rendimiento_kgxha FLOAT
);

INSERT INTO star.fact_table
SELECT ad.id as anio_id,
	   dd.id as departamento_id,
	   pd.id as provincia_id,
	   td.id as cultivo_id,
	   rawd.superficie_sembrada_ha,
	   rawd.superficie_cosechada_ha,
	   rawd.produccion_tm,
	   rawd.rendimiento_kgxha
FROM raw_data.all_raw_tables as rawd
LEFT JOIN src.Anio_dim as ad
ON rawd.anio = ad.anio -- Corrected from as.anio to ad.anio
LEFT JOIN src.Departamento_dim as dd
ON rawd.departamento_nombre = dd.departamento_nombre
LEFT JOIN src.Provincia_dim as pd
ON rawd.provincia_nombre = pd.provincia_nombre
LEFT JOIN src.TipoCultivo_dim as td
ON rawd.cultivo_nombre = td.cultivo_nombre