SELECT distinct cultivo_nombre from ##TempAllRawData;
SELECT distinct anio from ##TempAllRawData;
SELECT distinct provincia_nombre  from ##TempAllRawData;
SELECT distinct departamento_nombre from ##TempAllRawData;

-- DUPLICADOS
SELECT provincia_id, provincia_nombre FROM ##TempAllRawData WHERE provincia_id = 26;
SELECT * FROM ##TempAllRawData WHERE provincia_id = 26;


select * FROM ##TempAllRawData;
select * from raw_data.all_raw_tables

