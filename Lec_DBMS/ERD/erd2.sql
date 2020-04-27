
/* Drop Tables */

DROP TABLE lec CASCADE CONSTRAINTS;
DROP TABLE lecture CASCADE CONSTRAINTS;
DROP TABLE professor CASCADE CONSTRAINTS;
DROP TABLE student CASCADE CONSTRAINTS;
DROP TABLE department CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE department
(
	deptno number NOT NULL,
	phonenum varchar2(15),
	deptOffice varchar2(10),
	dname varchar2(10) NOT NULL,
	PRIMARY KEY (deptno)
);


CREATE TABLE lec
(
	studno number NOT NULL,
	lecno number NOT NULL
);


CREATE TABLE lecture
(
	lecno number NOT NULL,
	lecName varchar2(15) NOT NULL,
	grades varchar2(5),
	lecPerson number,
	lecRoom varchar2(10),
	lecDate date,
	profno number NOT NULL,
	PRIMARY KEY (lecno)
);


CREATE TABLE professor
(
	profno number NOT NULL,
	JUMIN char(14),
	address varchar2(40),
	profname varchar2(10) NOT NULL,
	profPosition varchar2(10),
	phonenum varchar2(15),
	hiredate date,
	deptno number NOT NULL,
	PRIMARY KEY (profno)
);


CREATE TABLE student
(
	studno number NOT NULL,
	JUMIN char(14),
	name varchar2(10) NOT NULL,
	grade number,
	phoneNum varchar2(15),
	address varchar2(40),
	deptno number NOT NULL,
	PRIMARY KEY (studno)
);



/* Create Foreign Keys */

ALTER TABLE professor
	ADD FOREIGN KEY (deptno)
	REFERENCES department (deptno)
;


ALTER TABLE student
	ADD FOREIGN KEY (deptno)
	REFERENCES department (deptno)
;


ALTER TABLE lec
	ADD FOREIGN KEY (lecno)
	REFERENCES lecture (lecno)
;


ALTER TABLE lecture
	ADD FOREIGN KEY (profno)
	REFERENCES professor (profno)
;


ALTER TABLE lec
	ADD FOREIGN KEY (studno)
	REFERENCES student (studno)
;



