-- SELECT 결과물중 맨 위의 5개만 출력해보고 싶으면 어케 해야 하나?
--   ex) 게시판.. 페이징

-- DBMS 마다 구현 방법 다름
--	MYSQL : LIMIT
-- 	MS SQL server : TOP
-- 	ORACLE : ROWNUM 

SELECT EMPNO ,ENAME ,SAL FROM T_EMP ;

-- 자동적으로 오라클에서 붙여주는 행번호 객체 (ROWNUM)
SELECT ROWNUM, EMPNO ,ENAME ,SAL FROM T_EMP ;

-- 직원번호 역순,  그러나 ROWNUM 은 1 ~
SELECT ROWNUM, EMPNO ,ENAME ,SAL FROM T_EMP ORDER BY EMPNO DESC ;

--- 상위 5개
SELECT ROWNUM, EMPNO ,ENAME ,SAL FROM T_EMP 
WHERE rownum <=5 
ORDER BY EMPNO DESC ;

-- SELECT 에 ROWNUM 없어도 동작
SELECT EMPNO ,ENAME ,SAL FROM T_EMP 
WHERE rownum <=5 
ORDER BY EMPNO DESC ;

-- ROWNUM > 5 ??? 동작안함... ROWNUM 범위가 1이 포함안되면 동작 안함.
SELECT ROWNUM, EMPNO ,ENAME ,SAL FROM T_EMP 
WHERE rownum > 5 
ORDER BY EMPNO DESC ;


-- 상위 5개 출력
-- row1 ~ row5 까지 출력(1 Page)
SELECT ROWNUM, empno , ename , sal FROM T_EMP 
WHERE ROWNUM >= 1 AND ROWNUM < 1 +5
ORDER BY empno DESC ;

-- (2 Page)
SELECT ROWNUM, empno , ename , sal FROM T_EMP 
WHERE ROWNUM >= 6 AND ROWNUM < 6 + 5
ORDER BY empno DESC ; -- 안나온다.. 후엥..


-- phonebook 뻥튀기..
SELECT  * FROM PHONEBOOK ;
INSERT INTO PHONEBOOK (SELECT  * FROM PHONEBOOK);

INSERT INTO PHONEBOOK 
	(SELECT PHONEBOOK_seq.nextval, PB_NAME ,PB_PHONENUM ,PB_MEMO,SYSDATE FROM PHONEBOOK );


-- ROWNUM rev.
SELECT pb_uid, pb_name, pb_phonenum FROM PHONEBOOK ORDER BY PB_UID DESC;


SELECT T.*
FROM (SELECT pb_uid, pb_name, pb_phonenum FROM PHONEBOOK ORDER BY PB_UID DESC) T;

SELECT ROWNUM AS RNUM, T.*
FROM (SELECT pb_uid, pb_name, pb_phonenum FROM PHONEBOOK ORDER BY PB_UID DESC) T;

SELECT ROWNUM AS RNUM, T.*
FROM (SELECT pb_uid, pb_name, pb_phonenum FROM PHONEBOOK ORDER BY PB_UID DESC) T;


-- 한 페이지 당 5개 데이터
-- 2번째 페이지
SELECT * FROM 
(
SELECT ROWNUM AS RNUM, T.*
FROM (SELECT pb_uid, pb_name, pb_phonenum FROM PHONEBOOK ORDER BY PB_UID DESC) T 
)
WHERE RNUM >=6 AND RNUM < 6+5;

-- 3page
SELECT * FROM 
(
SELECT ROWNUM AS RNUM, T.*
FROM (SELECT pb_uid, pb_name, pb_phonenum FROM PHONEBOOK ORDER BY PB_UID DESC) T 
)
WHERE RNUM >=11 AND RNUM < 11+5;

-- 네번째 페이지

SELECT * FROM 
(
SELECT ROWNUM AS RNUM, T.*
FROM (SELECT pb_uid, pb_name, pb_phonenum FROM PHONEBOOK ORDER BY PB_UID DESC) T 
)
WHERE RNUM >=16 AND RNUM < 16+5;


-- 한 페이지 당 10개 데이터
-- 3번째 페이지
SELECT * FROM 
(
SELECT ROWNUM AS RNUM, T.*
FROM (SELECT pb_uid, pb_name, pb_phonenum FROM PHONEBOOK ORDER BY PB_UID DESC) T 
)
WHERE RNUM >=21 AND RNUM < 21+10;












