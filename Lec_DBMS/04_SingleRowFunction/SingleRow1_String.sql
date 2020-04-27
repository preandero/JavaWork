-- INITCAP() 함수


-- #4101
SELECT INITCAP('pretty girl') 
FROM DUAL ;


-- #4102
SELECT ID ,INITCAP(ID) ID 
FROM T_STUDENT 
WHERE DEPTNO1 = 201;

-- LOWER(), UPPER()
-- #4103
SELECT NAME 이름 ,ID ,LOWER(ID) 소문자,UPPER(ID) 대문자 
FROM T_STUDENT 
WHERE DEPTNO1 = 201;


--LENGTH / LENGTHB
-- #4104
SELECT NAME ,ID ,LENGTH(ID) 글자수
FROM T_STUDENT 
WHERE LENGTH(ID) >= 9;  -- 단일행 함수는 WHERE 조건절에서 사용 가능!

-- #4105
SELECT NAME 이름 ,length(NAME) 길이, LENGTHB(NAME) 바이트 
FROM T_STUDENT 
WHERE DEPTNO1 = 201;


-- CONCAT() 함수
-- #4106
SELECT CONCAT(NAME ,POSITION ) 교수님이름 
FROM T_PROFESSOR 
WHERE DEPTNO = 101;

-- SUBSTR() 함수
SELECT SUBSTR('ABCDE',2,3) -- 'BCD' 문자열 인덱스 1부터 시작!
FROM DUAL ;

SELECT SUBSTR('ABCDE',20,3) -- null (에러 아님)
FROM DUAL ;

SELECT SUBSTR('ABCDE',-2, 2)
FROM DUAL ;

-- #4107
SELECT NAME ,SUBSTR(JUMIN ,1,6) 생년월일
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

-- #4108
SELECT NAME ,SUBSTR(JUMIN ,1,6) 생년월일 
FROM T_STUDENT 
WHERE SUBSTR(JUMIN ,3,2) ='08'; 

-- # 4109
SELECT NAME ,JUMIN 
FROM T_STUDENT 
WHERE GRADE = 4 AND SUBSTR(JUMIN ,7,1) = 2; 


-- INSTR() 함수 
SELECT INSTR('A*B*C*','*',1,1)
FROM DUAL ;

SELECT INSTR('A*B*C*','*',1,2)
FROM DUAL ;

SELECT INSTR('A*B*C*','*',1,3)
FROM DUAL ;

SELECT INSTR('A*B*C*','*',-4,1) -- 2 음수인덱스의 경우 검색도 음의 방향으로 진행
FROM DUAL ;

SELECT INSTR('A*B*C*','*',-4,2) -- 0  없으면 0 리턴
FROM DUAL ;

SELECT INSTR('A*B*C*','*',-2,2) -- 2  
FROM DUAL ;

-- #4110
--SELECT NAME ,TEL ,INSTR(TEL ,')',1,1) AS 위치
SELECT NAME ,TEL ,INSTR(TEL ,')') AS 위치
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

-- #4111
SELECT NAME ,TEL ,SUBSTR(TEL ,1,INSTR(TEL ,')')-1 ) 지역번호 
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

-- LTRIM() , RTRIM() 함수
SELECT LTRIM('슈퍼슈퍼슈가맨','슈퍼') LTRIM ,
		LTRIM('슈퍼슈퍼슈가맨','슈') LTRIM ,
		LTRIM('    슈퍼슈가맨', ' ') LTRIM, 
		LTRIM('    슈퍼슈가맨') LTRIM, -- 디폴트로 '공백' 제거 
		RTRIM('우측 공백 제거    ')RTRIM,
		TRIM('   슈퍼맨     ') TRIM , -- 좌우 공백 제거
		LTRIM ('*******10000','*') LTRIM  
FROM DUAL ; 

-- #4117
SELECT * 
FROM T_DEPT2 ;

SELECT dname, RTRIM(dname,'부') RTRIM예제 
FROM T_DEPT2 ;

-- REPLACE 함수
SELECT REPLACE ('슈퍼맨 슈퍼걸','슈퍼','파워') REPLACE 
FROM DUAL ;

SELECT REPLACE ('아버지가 방에 들어간다',' ','')
FROM DUAL ;


-- #4118
SELECT REPLACE (NAME ,SUBSTR(NAME ,1,1),'#' ) 학생
FROM T_STUDENT 
WHERE DEPTNO1 = 102;

-- #4119
SELECT REPLACE (NAME ,SUBSTR(NAME ,2,1),'#' ) 학생
FROM T_STUDENT
WHERE DEPTNO1 = 101;

-- #4120
SELECT NAME ,REPLACE (JUMIN ,SUBSTR(JUMIN ,7,7),'*******' )
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

-- #4121
SELECT NAME ,TEL ,REPLACE (TEL ,SUBSTR(TEL ,INSTR(TEL ,')',1)+1 ,3) ,'###' ) 전화번호
FROM T_STUDENT 
WHERE DEPTNO1 = 102;




