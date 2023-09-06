CREATE DATABASE hibernate_db;


CREATE TABLE IF NOT EXISTS users
( id INTEGER NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(128) NOT NULL,
  last_name VARCHAR(128) NOT NULL,
  age VARCHAR(56) NOT NULL,
  profession VARCHAR(128) NOT NULL,
  PRIMARY KEY (id)
);


-- HQL
INSERT INTO User (firstName, lastName, age, profession) VALUES (:firstName, :lastName, :age, :profession)
-- SQL
INSERT INTO users (first_name, last_name, age, profession) VALUES (:first_name, :last_name, :age, :profession)


-- HQL
FROM User
-- SQL
SELECT * FROM users


-- HQL
UPDATE User SET profession = :profession WHERE id = :id
-- SQL
UPDATE users SET profession = :profession WHERE id = :id


-- HQL
DELETE FROM User WHERE id = :id
-- SQL
DELETE FROM users WHERE id = :id;
