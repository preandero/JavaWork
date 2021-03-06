-- Sub Query

-- #7101

SELECT * FROM T_EMP ;

--SELECT sal FROM T_EMP WHERE ENAME = 'SCOTT' ; -- SubQuery 먼저 만들어서 사용하기

SELECT ENAME , SAL 
FROM T_EMP 
WHERE sal > (SELECT sal FROM T_EMP WHERE ENAME = 'SCOTT') ;


SELECT MAX(HEIGHT) FROM T_STUDENT;

SELECT NAME, HEIGHT 
FROM T_STUDENT
WHERE HEIGHT = (SELECT MAX(HEIGHT) FROM T_STUDENT);

-- 1. 단일행 서브쿼리

-- #7103

SELECT DEPTNO1
FROM T_STUDENT 
WHERE NAME = '이윤나';

SELECT  s.NAME "학생이름",d.DNAME "1전공"
FROM T_STUDENT s,T_DEPARTMENT d
WHERE d.DEPTNO = s.DEPTNO1 
AND s.DEPTNO1 = (SELECT DEPTNO1 FROM T_STUDENT WHERE NAME = '이윤나');

-- #7104

SELECT HIREDATE FROM T_PROFESSOR WHERE NAME = '송도권';

SELECT p.NAME "교수명", TO_CHAR(p.HIREDATE,'YYYY-MM-DD') "입사일" ,d.DNAME "학과명"
FROM T_PROFESSOR p, T_DEPARTMENT d
WHERE p.DEPTNO = d.DEPTNO 
AND p.HIREDATE > (SELECT HIREDATE FROM T_PROFESSOR WHERE NAME = '송도권');

-- #7105

SELECT DEPTNO1, AVG(WEIGHT) FROM T_STUDENT WHERE DEPTNO1 = '101' GROUP BY DEPTNO1 ;

SELECT NAME "이름",WEIGHT "몸무게" 
FROM T_STUDENT 
WHERE WEIGHT > (SELECT AVG(WEIGHT) FROM T_STUDENT WHERE DEPTNO1 = '101' GROUP BY DEPTNO1);

-- #7106

SELECT HIREDATE FROM T_PROFESSOR WHERE NAME = '심슨';
SELECT PAY FROM T_PROFESSOR WHERE NAME ='조인형';

SELECT NAME "이름", PAY "급여", TO_CHAR(HIREDATE,'RR/MM/DD') "입사일"
FROM T_PROFESSOR 
WHERE  HIREDATE = (SELECT HIREDATE FROM T_PROFESSOR WHERE NAME = '심슨')
AND PAY < (SELECT PAY FROM T_PROFESSOR WHERE NAME ='조인형');


-- 2. 다중행 쿼리

-- #7107

SELECT * FROM T_EMP2 ;
SELECT * FROM T_DEPT2 ;

SELECT dcode FROM T_DEPT2 WHERE AREA = '서울지사';


SELECT EMPNO , NAME ,DEPTNO 
FROM T_EMP2
WHERE DEPTNO IN (SELECT dcode FROM T_DEPT2 WHERE AREA = '서울지사');


-- #7108

SELECT * FROM T_EMP2 ;

SELECT PAY FROM T_EMP2 WHERE POST = '과장';

SELECT NAME "이름",POST "직급", TO_CHAR(PAY, '999,999,999')|| '원' "연봉" 
FROM T_EMP2 
WHERE pay  >ANY (SELECT PAY FROM T_EMP2 WHERE POST = '과장');  

-- #7109
SELECT WEIGHT FROM T_STUDENT WHERE GRADE =4;

SELECT NAME "이름", GRADE "학년", WEIGHT "몸무게"
FROM T_STUDENT 
WHERE WEIGHT <ALL (SELECT WEIGHT FROM T_STUDENT WHERE GRADE =4);

