-- Question: https://stackoverflow.com/questions/77226448/group-by-vertical-and-horizontal-data/77226491#77226491

DROP TABLE IF EXISTS Registration
CREATE TABLE Registration (
    Type1 INT,
    Type2 INT,
    Type3 INT,
    Type4 INT,
    RegistrationDateTime DATE
);

INSERT INTO Registration (Type1, Type2, Type3, Type4, RegistrationDateTime)
VALUES 
    (0, 1, 0, 0, '2023-01-29'),
    (1, 0, 0, 0, '2023-01-30'),
    (0, 0, 1, 0, '2023-02-15'),
	(1, 0, 0, 0, '2023-02-25'),
    (0, 0, 0, 1, '2023-03-10'),
    (1, 0, 0, 0, '2023-03-12'),
	(0, 0, 0, 1, '2023-04-01'),
    (0, 0, 0, 1, '2023-04-05'),
    (0, 0, 1, 0, '2023-04-10'),
    (0, 1, 0, 0, '2023-05-02'),
    (1, 0, 0, 0, '2023-05-15'),
    (0, 0, 1, 0, '2023-06-01'),
    (1, 0, 0, 0, '2023-06-02'),
    (0, 0, 1, 0, '2023-07-20'),
    (1, 0, 0, 0, '2023-08-12'),
    (0, 1, 0, 0, '2023-08-18'),
    (0, 0, 1, 0, '2023-09-05'),
    (0, 0, 0, 1, '2023-09-30');

SELECT 
    FORMAT(x.RegistrationDateTime, 'MMMM') AS Month,
    SUM(Type1) AS Type1,
    SUM(Type2) AS Type2,
    SUM(Type3) AS Type3,
    SUM(Type4) AS Type4,
    COUNT(*) AS Total
FROM (
    SELECT 
        CASE 
            WHEN r.Type1 = 1 THEN 1 ELSE 0 
        END AS Type1,
        CASE 
            WHEN r.Type2 = 1 THEN 1 ELSE 0 
        END AS Type2,
        CASE 
            WHEN r.Type3 = 1 THEN 1 ELSE 0 
        END AS Type3,
        CASE 
            WHEN r.Type4 = 1 THEN 1 ELSE 0 
        END AS Type4,
        r.RegistrationDateTime
    FROM Registration AS r 
) AS x
GROUP BY FORMAT(x.RegistrationDateTime, 'MMMM')
ORDER BY MIN(x.RegistrationDateTime);