# Pivot
CREATE DATABASE IF NOT EXISTS testing_database;
USE testing_database;
DROP TABLE IF EXISTS store;
CREATE TABLE IF NOT EXISTS store(
`Shirt_color` VARCHAR(10),
`Paul` INT,
`John` INT, 
`Tim` INT,
`Eric` INT);

INSERT INTO `testing_database`.`store`
(`Shirt_color`,`Paul`,`John`,`Tim`,`Eric`)
VALUES
('Red',1,3,1,5),
('Green',8,4,3,5),
('Blue',2,2,9,1);

SELECT * FROM store;

Select sum(*) fron store
group bt Shirt_color;		

