#Insipred in this question: https://stackoverflow.com/questions/75557226/sql-query-to-find-sum-of-two-particular-rows
CREATE TABLE IF NOT EXISTS users(
`id` int,
`name` VARCHAR(10),
`age` INT,
`role` INT
);

INSERT INTO `testing_database`.`users` (`id`,`name`,`age`,`role`)
VALUES
(1,       "Rahul",          20,              1),
(2,       "Karan",          35,              0),
(3,       "Vivek",          47,              0),
(4,       "Subam",          40,              1),
(5,       "Paras",          87,              1),
(6,       "Arjun",          18,              1),
(7,       "Ayush",          28,              0);

SELECT t1.id, 
	   t1.name, 
       t1.role, 
       t1.age as t1_age, 
       t2.age as t2_age,
       (t1.age  + t2.age ) as sum_age
FROM testing_database.users as t1
CROSS JOIN testing_database.users as t2
ON t1.id != t2.id
WHERE (t1.age  + t2.age) = 60