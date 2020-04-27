-- JOIN


-- FROM 절에 테이블에도 별칭(alias)를 줄 수 있다!

-- 20 레코드
SELECT s.STUDNO, s.NAME , s.DEPTNO1 
FROM T_STUDENT s;

-- 12 레코드
SELECT d.BUILD ,d.DEPTNO, d.DNAME ,d.PART 
FROM T_DEPARTMENT d;

-- 카티션곱 (Cartesian Product)
-- 두개의 테이블을 JOIN 하게 되면, 
-- 각 테이블의 레코드들의 모든 조합이 출력된다.
-- WHERE 나 ON 등으로 JOIN 조건이 주어지지 않으면 
-- 모든 카티션곱이 출력된다. 

--240개 --
SELECT s.STUDNO ,s.NAME ,s.DEPTNO1 ,
	d.DEPTNO ,d.DNAME 
FROM T_STUDENT s, T_DEPARTMENT d; -- Oracle 방식

SELECT s.STUDNO ,s.NAME ,s.DEPTNO1 ,
	d.DEPTNO ,d.DNAME 
FROM T_STUDENT s
		CROSS JOIN T_DEPARTMENT d; -- ANSI 방식
		
		
-- Equi Join (등가 join)
-- Oracle Join 방식
SELECT s.NAME "학생이름", s.DEPTNO1 "학과번호" , d.DNAME "학과이름"
FROM T_STUDENT s , T_DEPARTMENT d
WHERE s.DEPTNO1 = d.DEPTNO ;
		
-- ANSI 방식

SELECT s.NAME "학생이름", s.DEPTNO1 "학과번호" , d.DNAME "학과이름"
FROM T_STUDENT s JOIN T_DEPARTMENT d
ON s.DEPTNO1 = d.DEPTNO ;

SELECT * FROM T_STUDENT ;

-- 제 2전공은? deptno2
SELECT s.NAME "학생이름" ,s.DEPTNO2 "제2학과", d.DNAME "제2학과이름"
FROM T_STUDENT s, T_DEPARTMENT d
WHERE s.DEPTNO2 = d.DEPTNO ;

-- #6102
SELECT s.NAME "학생이름" , p.PROFNO "지도교수" ,p.NAME "지도교수이름"
FROM T_STUDENT s ,T_PROFESSOR p 
WHERE s.PROFNO = p.PROFNO ;

SELECT s.NAME "학생이름" , p.PROFNO "지도교수" ,p.NAME "지도교수이름"
FROM T_STUDENT s JOIN T_PROFESSOR p
ON s.PROFNO = p.PROFNO ;

-- #6103
SELECT s.NAME , d.DNAME , p.NAME 
FROM T_STUDENT s ,T_DEPARTMENT d,T_PROFESSOR p 
WHERE s.DEPTNO1 = d.DEPTNO AND s.PROFNO =p.PROFNO  ;

SELECT s.NAME , d.DNAME , p.NAME 
FROM T_STUDENT s 
JOIN T_DEPARTMENT d ON s.DEPTNO1 = d.DEPTNO  
JOIN T_PROFESSOR p  ON s.PROFNO =p.PROFNO ;

-- #6104
SELECT e.NAME "사원이름", p.POST "현재", e.PAY"현재연봉" , p.S_PAY "하한금액", p.E_PAY "상한금액" 
FROM T_EMP2 e, T_POST p
WHERE e.POST = p.POST ;

SELECT e.NAME "사원이름", p.POST "현재", e.PAY"현재연봉" , p.S_PAY "하한금액", p.E_PAY "상한금액"  
FROM T_EMP2 e join T_POST p
ON e.POST = p.POST ;

-- #6105
SELECT s.NAME , p.NAME 
FROM T_STUDENT s, T_PROFESSOR p
WHERE s.PROFNO = p.PROFNO AND s.DEPTNO1 =101;

SELECT s.NAME , p.NAME 
FROM T_STUDENT s join T_PROFESSOR p
on s.PROFNO = p.PROFNO AND s.DEPTNO1 =101;





