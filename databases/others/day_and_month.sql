-- Inspired in: https://stackoverflow.com/questions/76657922/date-format-and-str-to-date-are-not-working/76657944#76657944

CREATE TABLE may2023 (
  datetime VARCHAR(50)
);

INSERT INTO may2023 (datetime)
VALUES ('05/01/2023 04:33:59 AM');

SELECT
  DATE_FORMAT(STR_TO_DATE(datetime, '%m/%d/%Y %h:%i:%s %p'), '%m') AS month,
  DATE_FORMAT(STR_TO_DATE(datetime, '%m/%d/%Y %h:%i:%s %p'), '%d') AS day
FROM may2023;