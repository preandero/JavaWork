SELECT *
FROM T_PROFESSOR;

SELECT COUNT(*),COUNT(HPAGE) 
FROM T_PROFESSOR ; -- 그룹함수에서는 NULL 값은 계산에서 제외

SELECT COUNT(bonus),sum(bonus),avg(BONUS)
FROM T_PROFESSOR;  

SELECT max(hiredate), min(hiredate) FROM T_EMP ;

-- NULL 허용 컬럼의 그룹함수 적용 시
-- nvl, nvl2 사용해야함
SELECT AVG(BONUS), avg(NVL(BONUS,0))
FROM T_PROFESSOR  ;

-- t_professor 테이블에서 '학과별' 로 교수들의 평균 보너스를 출력하세요

-- 불가능하다! SELECT 절에 group 함수와 group 함수가 아닌 것과는 같이 출력 불가
--SELECT DEPTNO , AVG(BONUS) 
--FROM T_PROFESSOR 

SELECT DEPTNO , ROUND(avg(nvl(BONUS,0)),1) 보너스평균
FROM T_PROFESSOR
GROUP BY DEPTNO;

-- #5101
SELECT DEPTNO ,POSITION , avg(pay) 평균급여
FROM T_PROFESSOR 
GROUP BY DEPTNO , POSITION  -- 1.학과별 GROUPING, 2.직급별 GROUPING
ORDER BY DEPTNO ASC , POSITION ASC; 


-- 부서별 평균급여를 출력하되, 평균급여가 450 보다 많은 학과만 출력
SELECT DEPTNO ,AVG(PAY) 평균급여 
FROM T_PROFESSOR 
--WHERE AVG(pay)>450 -- 그룹함수는 WHERE절에서 사용 불가!
GROUP BY DEPTNO ;

-- HAVING : 그룹함수 결과에 대한 조건절
SELECT DEPTNO ,AVG(PAY) 평균급여 
FROM T_PROFESSOR 
GROUP BY DEPTNO 
HAVING AVG(pay)>300;

-- <SELECT 쿼리문 순서>

-- SELECT
-- FROM
-- WHERE
-- GROUP BY
-- HAVING
-- ORDER BY
 
-- #5102
SELECT *
FROM T_EMP ;


SELECT MGR 매니저, COUNT(*)직원수 ,SUM(sal) 급여총액, TRUNC (avg(sal)) 급여평균,avg(nvl(COMM,0)) 교통비평균 
FROM T_EMP 
GROUP BY MGR 
HAVING MGR IS NOT NULL;

-- #5103
SELECT *
FROM T_PROFESSOR 

SELECT DEPTNO , COUNT(*) 총인원, ROUND(AVG(SYSDATE - hiredate),1) 근속평균, 
		AVG(pay) 급여평균 ,avg(nvl(BONUS,0)) 보너스평균
FROM T_PROFESSOR
WHERE POSITION ='정교수' OR POSITION = '조교수'
GROUP BY DEPTNO;

-- #5104
SELECT DEPTNO1 학과 , MAX(WEIGHT ) - min(WEIGHT) 최대최소몸무게차
FROM T_STUDENT 
GROUP BY DEPTNO1 

-- #5105
SELECT DEPTNO1 학과 , MAX(WEIGHT ) - min(WEIGHT) 최대최소몸무게차
FROM T_STUDENT 
GROUP BY DEPTNO1 
HAVING MAX(WEIGHT ) - min(WEIGHT)>=30;
