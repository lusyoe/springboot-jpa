DROP TABLE IF EXISTS test.person;

CREATE TABLE IF NOT EXISTS test.person(
id      INT PRIMARY KEY AUTO_INCREMENT,
name    VARCHAR(20),
age     INT,
address VARCHAR(40)
);

-- Spring Boot auto init table struct
