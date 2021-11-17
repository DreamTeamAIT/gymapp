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
	INSERT INTO timetable VALUES (not null,'10:00', 'Performance Gym', 'Thiago');
	INSERT INTO timetable VALUES (not null,'11:00', 'Poolside Gym', 'Peter');
	INSERT INTO timetable VALUES (not null,'12:00', 'Performance Gym', 'Shein');
	INSERT INTO timetable VALUES (not null,'14:00', 'Poolside Gym', 'Saksham');
	INSERT INTO timetable VALUES (not null,'15:00', 'Performance Gym', 'Eoghan');
	INSERT INTO timetable VALUES (not null,'16:00', 'Poolside Gym', 'Agron');
	INSERT INTO timetable VALUES (not null,'17:00', 'Performance Gym', 'Agron');
   
    SELECT * FROM timetable;
    SELECT * FROM timetable where myTime = '09:00'; 
    SELECT * FROM timetable where myClass = 'Poolside Gym'; 
    SELECT * FROM timetable where instructor = 'Agron'; 
