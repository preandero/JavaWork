-- dual 은 ROW 1개 짜리 dummy TABLE;
SELECT 'abcde' FROM dual;
SELECT '안녕하세요' FROM dual;
SELECT 100 FROM dual;
SELECT 100 + 10 FROM dual;

-- * : '모든 컬럼'
SELECT * FROM T_EMP ;

-- 원하는 컬럼만 조회
SELECT EMPNO ,ENAME 
FROM T_EMP ;

--
SELECT * FROM T_PROFESSOR ;

SELECT name FROM T_PROFESSOR ;
SELECT bonus FROM T_PROFESSOR ;



SELECT '안녕하세요' FROM T_PROFESSOR ;

SELECT name, '교수님 싸랑해요' FROM T_PROFESSOR ;

-- 컬럼 별명(alias) 사용한 출력
SELECT STUDNO 학번 ,NAME 이름 
FROM T_STUDENT ;

SELECT studno "학번", name AS 이름
FROM T_STUDENT ;

SELECT studno "학생 학번", name AS 이름
FROM T_STUDENT ;

SELECT EMPNO 사원번호, ENAME 사원명, JOB 직업 FROM T_EMP ;

SELECT DEPTNO "부서#",DNAME 부서명,LOC 위치 FROM T_DEPT ;

-- DISTINCT 
SELECT * FROM T_EMP ;
SELECT deptno FROM T_EMP ;
SELECT DISTINCT deptno FROM T_EMP ;

-- 1.학생테이블(t_student) 에서 제1전공 (deptno1) 을 중복값을 제거하여 출력해보기
SELECT DISTINCT DEPTNO1 FROM T_STUDENT ;

-- 2. 직원(t_emp) 들의 직책(job) 을 중복값 제거하여  출력해보기
SELECT DISTINCT job FROM T_EMP ;


-- || : 필드, 문자열 연결 연산
SELECT name, POSITION 
FROM T_PROFESSOR ;

SELECT name || '-' || POSITION AS 교수님명단 
FROM T_PROFESSOR ;

-- 학생테이블(t_student)를 사용하여 모든 학생들이 
-- ‘서진수의 키는 180cm, 몸무게는 55kg 입니다’ 와 같은 형식으로 출력되도록 문자를 추가하고, 
-- 칼럼 이름은 ‘학생의 키와 몸무게’ 라는 별명으로 출력하세요

SELECT NAME || '의 키는' || HEIGHT || 'cm, ' || '몸무게는 ' || WEIGHT || 'kg 입니다' "학생의 키와 몸무게" 
FROM T_STUDENT ;




