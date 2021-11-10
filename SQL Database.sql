#database setup
create database if not exists gym;
use gym;

#Login set up
drop table if exists login;
CREATE TABLE if not exists `login` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
);
Insert into login Values ("Peter", "12345");
Insert into login Values ("t", "t");

#Classes setup
drop table if exists classes;
CREATE TABLE if not exists classes (
  classID INT NOT NULL  AUTO_INCREMENT ,
  classname varchar(45) DEFAULT NULL,
  instructor varchar(45) DEFAULT NULL,
  classtime varchar(45) DEFAULT NULL,
PRIMARY KEY(classID)
);
insert into classes VALUES (0, "Yoga", "Agron", "12:00");

#Instructor set-up
drop table if exists instructor;
CREATE TABLE if not exists `instructor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT "None",
  `gender` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
insert into instructor VALUES(0, "Agron", "Male");

#Customer set up
DROP TABLE IF EXISTS customer ;
CREATE TABLE if not exists `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
;

INSERT INTO customer (id, first_name, last_name, password, email)
VALUES (1, "Peter", "Curry", "12345", "email@email.com");
INSERT INTO customer (id, first_name, last_name, password, email)
VALUES (2, "Paul", "Rice", "678910", "paulrocks@email.com");

#create database timetable;
DROP TABLE IF EXISTS timetable;

    CREATE TABLE timetable (
	id INTEGER AUTO_INCREMENT NOT NULL,
	myTime VARCHAR(15) NOT NULL,
	myClass VARCHAR(20) NOT NULL,
	instructor VARCHAR(20) NOT NULL,
    PRIMARY KEY (id));
    
	INSERT INTO timetable VALUES (not null,'09:00', 'Poolside Gym', 'Agron');
   
    SELECT * FROM timetable;
    SELECT * FROM classes;
    SELECT * FROM instructor;
    SELECT * FROM customer;
    
    

    