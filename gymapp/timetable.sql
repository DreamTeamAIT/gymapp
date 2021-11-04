#create database timetable;

DROP DATABASE IF EXISTS timetable;
CREATE DATABASE IF NOT EXISTS timetable;
USE timetable;
DROP TABLE IF EXISTS timetable;

    CREATE TABLE timetable (
	id INTEGER AUTO_INCREMENT NOT NULL,
	myTime VARCHAR(15) NOT NULL,
	myClass VARCHAR(20) NOT NULL,
	instructor VARCHAR(20) NOT NULL,
    PRIMARY KEY (id));
    
	INSERT INTO timetable VALUES (not null,'09:00', 'Poolside Gym', 'Agron');
   
    SELECT * FROM timetable;
    SELECT * FROM timetable where myTime = '09:00'; 
    SELECT * FROM timetable where myClass = 'Poolside Gym'; 
	SELECT * FROM timetable where instructor = 'Agron'; 
