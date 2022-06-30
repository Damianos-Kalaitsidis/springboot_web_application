CREATE DATABASE  IF NOT EXISTS 'test';
USE 'test';

--
-- Table structure for table 'students'
--

DROP TABLE IF EXISTS 'students';

CREATE TABLE 'students' (
  'id' int(11) NOT NULL AUTO_INCREMENT,
  'idStudent' int(11) NOT NULL AYTO_INCREMENT,
  'first_name' varchar(45) DEFAULT NULL,
  'last_name' varchar(45) DEFAULT NULL,
  'email' varchar(45) DEFAULT NULL,
  PRIMARY KEY ('id')
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table 'students'
--

INSERT INTO 'students' VALUES 
	(1,4441,'Eftychia','Bourli','leslie@luv2code.com'),
	(2,4370,'Damianos','Kalaitsidis','emma@luv2code.com'),
	(3,4582,'Avani','Gupta','avani@luv2code.com'),
	(4,4871,'Yuri','Petrov','yuri@luv2code.com'),
	(5,5512,'Juan','Vega','juan@luv2code.com');