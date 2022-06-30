CREATE DATABASE  IF NOT EXISTS 'test';
USE 'test';

--
-- Table structure for table 'courses'
--

DROP TABLE IF EXISTS 'courses';

CREATE TABLE 'courses' (
  'id' int(11) NOT NULL AUTO_INCREMENT,
  'name' varchar(45) DEFAULT NULL,
  'year' varchar(45) DEFAULT NULL,
  'semester' varchar(45) DEFAULT NULL,
  'syllabus' varchar(200) DEFAULT NULL,
  'exam' double(200) DEFAULT NULL,
  'project' double(200) DEFAULT NULL,
  PRIMARY KEY ('id')
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table 'courses'
--
INSERT INTO 'student' VALUES 
	(1,'robotiki','22/7/2001','4','ok',0.5,0.5);
