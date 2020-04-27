-- 3. 다중칼럼 SubQuery

-- #7201
SELECT GRADE "학년", MAX(HEIGHT) "키" FROM T_STUDENT GROUP BY GRADE  ;

SELECT GRADE "학년", NAME "이름", HEIGHT "키" 
FROM T_STUDENT  
WHERE (grade,HEIGHT ) IN (SELECT GRADE, MAX(HEIGHT) FROM T_STUDENT GROUP BY GRADE )
ORDER BY GRADE ASC;

-- #7202

SELECT p.profno "교수번호", p.name "교수명",
	    TO_CHAR(p.hiredate, 'YYYY-MM-DD') "입사일", d.dname "학과명"
FROM t_professor p, t_department d
WHERE p.deptno = d.deptno
AND (p.deptno, p.hiredate) 
	IN ( SELECT deptno, MIN(hiredate) FROM t_professor GROUP BY deptno)
ORDER BY d.dname ASC;

-- #7203

SELECT POST , MAX(PAY) FROM T_EMP2 WHERE POST IS NOT NULL GROUP BY POST ;

SELECT NAME "이름" , POST"직급" , PAY "연봉"
FROM T_EMP2 
WHERE (POST,PAY) IN (SELECT POST , MAX(PAY) FROM T_EMP2 WHERE POST IS NOT NULL GROUP BY POST)
ORDER BY PAY ASC ;

-- #7204

SELECT avg(e.PAY) FROM T_EMP2 e GROUP BY DEPTNO ;

SELECT d.DNAME"부서명" , e.NAME "직원명" , e.PAY "연봉"
FROM T_EMP2 e,T_DEPT2 d
WHERE e.DEPTNO = d.DCODE  
AND e.PAY <ALL (SELECT avg(e.PAY) FROM T_EMP2 e GROUP BY DEPTNO)
ORDER BY e.PAY ASC;


-- #7205 

SELECT a.NAME "이름" , nvl(a.POST,' ') "직급", a.PAY "급여" 
FROM T_EMP2 a  
WHERE 
	a.PAY >= 	
	(SELECT AVG(b.PAY) FROM T_EMP2 b WHERE NVL(a.POST,' ') = NVL(b.POST,' '));

SELECT AVG(b.PAY) FROM T_EMP2 b WHERE  = b.POST ; 


-- #7206

SELECT NAME "사원이름", (SELECT DNAME FROM T_DEPT2 d WHERE e.deptno = d.DCODE ) "부서이름"
FROM T_EMP2 e;