DROP DATABASE IF EXISTS mealDB;
CREATE DATABASE mealDBtest;

USE mealDBtest;

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