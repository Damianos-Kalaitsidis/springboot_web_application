CREATE DATABASE  IF NOT EXISTS 'test';
USE 'test';

--
-- Table structure for table 'Grades'
--

DROP TABLE IF EXISTS 'Grades';

CREATE TABLE 'Grades' (
  'id' int(11) NOT NULL AUTO_INCREMENT,
  'idStudent' int(11) NOT NULL AUTO_INCREMENT,
  'course' varchar(45) DEFAULT NULL,
  'grade' varchar(45) DEFAULT NULL,
  'exam' double(45) DEFAULT NULL,
  'project' double(45) DEFAULT NULL,
  'grfinalGrade' double(45) DEFAULT NULL,
  PRIMARY KEY ('id')
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table 'Grades'
--
INSERT INTO 'student' VALUES 
	(1,4441,'Eftychia','robotiki',5,5.5,5),