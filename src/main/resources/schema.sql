DROP DATABASE IF EXISTS mealDB;
CREATE DATABASE mealDB;

USE mealDB;

CREATE TABLE user(
	userId INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE meal(
mealId INT PRIMARY KEY AUTO_INCREMENT,
meal_items VARCHAR(40) NOT NULL,
meal_title VARCHAR(255) NOT NULL,
calories double,
protein double,
sugar double,
fat double,
salt double,
userId INT NOT NULL,
FOREIGN KEY (userId) REFERENCES user(userId));

INSERT INTO user(userId, name)
VALUES(1, "Peter Smith"), (2, "William Anderson");

INSERT INTO meal(mealId, meal_items, meal_title, calories, protein, sugar, fat, salt, userId) VALUES (1, "chicken and rice", "FAVOURITE LUNCH", 500.2, 45.1, 4.5, 2.6, 4.7, 2);
