

CREATE OR REPLACE VIEW v_prof
AS 
SELECT profno, name, email , hpage
FROM T_PROFESSOR ; 


SELECT * FROM v_prof;

SELECT tname FROM tab; -- VIEW 확인 가능

-- VIEW 생성시 별도의 컬럼 이름을 지정해줄 수 있다.
CREATE OR REPLACE VIEW v_prof(pfno, nm, em, hp)
AS 
SELECT profno, name, email , hpage
FROM T_PROFESSOR ; 


SELECT * FROM v_prof;

-- #8102

CREATE OR REPLACE VIEW v_prof_dept("교수번호","교수명","소속학과명")
AS
SELECT p.PROFNO ,p.NAME , d.DNAME 
FROM T_PROFESSOR p,T_DEPARTMENT d
WHERE p.DEPTNO = d.DEPTNO ;

SELECT * FROM v_prof_dept;

SELECT d.DNAME , MAX(s.HEIGHT) , MAX(s.WEIGHT ) 
FROM T_STUDENT s,T_DEPARTMENT d
WHERE s.DEPTNO1 = d.DEPTNO 
GROUP BY d.DNAME ;

-- #8104

SELECT d.DNAME "학과명", MAX(s.HEIGHT ) 
FROM T_STUDENT s,T_DEPARTMENT d
WHERE d.DEPTNO  = s.DEPTNO1 
GROUP BY d.DNAME ;

SELECT  d.DNAME "학과명", a.max_height"최대키", s.NAME "학생이름", s.HEIGHT "키"
FROM (SELECT DEPTNO1 , MAX(HEIGHT ) max_height FROM T_STUDENT GROUP BY DEPTNO1 ) a,
		t_student s, t_department d
WHERE 
s.DEPTNO1 = a.deptno1 AND s.HEIGHT = a.max_height
AND s.DEPTNO1 = d.DEPTNO ;


-- #8105
SELECT s.grade "학년", s.name "이름", s.height "키", a.avg_height "평균키" 
FROM (SELECT grade, AVG(height) avg_height FROM T_STUDENT GROUP BY GRADE) a , 
	t_student s 
WHERE a.grade = s.grade AND s.height > a.avg_height
ORDER BY s.GRADE ASC ;

select sum(bytes / (1024*1024)) "DB Size in MB" from dba_data_files;

<- 은행 -> 지점 -> 도시 

