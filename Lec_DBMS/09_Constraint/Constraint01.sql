-- 제약조건 (Constraint)
-- 테이블 생성시 동시에 설정하기

-- t_dept2.dcode 참조 예정
SELECT * FROM T_DEPT2; -- dcode : 0001, 1000, 1001... 1011

-- #9001
-- 제약조건명을 명시하지 않는 방법

DROP TABLE t_emp3 CASCADE CONSTRAINT;
CREATE TABLE t_emp3 (
	NO NUMBER(4) PRIMARY key, 
	name VARCHAR2(10) NOT null,
	jumin VARCHAR2(13) NOT NULL UNIQUE,
	area NUMBER(1) CHECK(area < 5),
	deptno VARCHAR2(6) REFERENCES t_dept2(dcode)
);

-- 별도의 항목으로 제약조건 정의 가능
CREATE TABLE t_emp4 (
	NO NUMBER(4) , 
	name VARCHAR2(10) NOT null,
	jumin VARCHAR2(13) NOT NULL,
	area NUMBER(1),
	deptno VARCHAR2(6),
	PRIMARY KEY(no),
	UNIQUE(jumin),
	CHECK(area < 5),
	FOREIGN KEY(deptno) REFERENCES t_dept2(dcode)
);

-- #9002 
-- 제약조건명을 명시하여 정의

DROP TABLE t_emp3 CASCADE CONSTRAINT;
CREATE TABLE t_emp3 (
	NO NUMBER(4) CONSTRAINT emp3_no_pk PRIMARY key, 
	name VARCHAR2(10) CONSTRAINT emp3_name_nn NOT null,
	jumin VARCHAR2(13) CONSTRAINT emp3_jumin_nn NOT NULL CONSTRAINT emp3_jumin_uk UNIQUE,
	area NUMBER(1) CONSTRAINT emp3_area_ck CHECK(area < 5),
	deptno VARCHAR2(6) CONSTRAINT emp3_deptno_deptno_fk REFERENCES t_dept2(dcode)
);


DROP TABLE t_emp3 CASCADE CONSTRAINT;
CREATE TABLE t_emp3 (
	NO NUMBER(4) , 
	name VARCHAR2(10) CONSTRAINT emp3_name_nn NOT null,
	jumin VARCHAR2(13) CONSTRAINT emp3_jumin_nn NOT NULL,
	area NUMBER(1) ,
	deptno VARCHAR2(6),
	CONSTRAINT emp3_no_pk PRIMARY KEY(no),
	CONSTRAINT emp3_jumin_uk UNIQUE(jumin),
	CONSTRAINT emp3_area_ck CHECK(area < 5),
	CONSTRAINT emp3_deptno_fk FOREIGN KEY(deptno) REFERENCES t_dept2(dcode) 
);

-- #9003 제약조건 조회하기
SELECT OWNER , CONSTRAINT_name, CONSTRAINT_type, STATUS 
FROM USER_CONSTRAINTS 
WHERE table_name = 'T_EMP4'; -- 테이블명 대문자로!

SELECT OWNER , CONSTRAINT_name, CONSTRAINT_type, STATUS 
FROM USER_CONSTRAINTS 
WHERE table_name = 'T_EMP3';

-- #9005 : 제약조건에 맞는 / 위배되는 DML 시도해보기
INSERT INTO t_emp3 VALUES(1, '오라클','1234561234567', 4, 1000);
-- 두번 실행하면 오류! SQL Error [1] [23000]: ORA-00001: unique constraint (SCOTT0316.EMP3_NO_PK) violated

INSERT INTO t_emp3 VALUES(2, '오라클','1234561234567', 4, 1000);
-- SQL Error [1] [23000]: ORA-00001: unique constraint (SCOTT0316.EMP3_JUMIN_UK) violated

INSERT INTO t_emp3 VALUES(2, '오라클','2222222222222222', 4, 1000);
-- SQL Error [12899] [72000]: ORA-12899: value too large for column "SCOTT0316"."T_EMP3"."JUMIN" (actual: 16, maximum: 13)

INSERT INTO t_emp3 VALUES(2, '오라클','2222222222222', 10, 1000);
-- SQL Error [1438] [22003]: ORA-01438: value larger than specified precision allowed for this column

INSERT INTO t_emp3 VALUES(2, '오라클','2222222222222', 3, 2000);
-- SQL Error [2291] [23000]: ORA-02291: integrity constraint (SCOTT0316.EMP3_DEPTNO_FK) violated - parent key not found

INSERT  INTO T_EMP3 (NO,jumin,area, deptno) VALUES (2, '3333333333333',4,1001);
-- SQL Error [1400] [23000]: ORA-01400: cannot insert NULL into ("SCOTT0316"."T_EMP3"."NAME")

-- INSERT 뿐 아니라 UPDATE/DELETE 에서도 오류 발생 가능
UPDATE t_emp3 SET area = 10 WHERE NO = 1; -- CHECK 값 오류

SELECT * FROM t_emp3;

DELETE FROM T_DEPT2 WHERE dcode = 1000; -- 참조하고 있는 부모는 삭제 불가

-- #9005) 테이블 생성후에 ALTER 명령 사용하여 제약조건 추가 가능!
-- t_emp4 의 name 컬럼 UNIQUE 제약조건 추가
-- ALTER ~ ADD
-- ALTER ~ MODIFY
-- ALTER ~ DROP
ALTER TABLE t_emp4 ADD CONSTRAINT emp4_name_uk UNIQUE(NAME);

-- #9006 
-- t_emp4
ALTER TABLE T_emp4 ADD CONSTRAINT emp4_area_nn NOT NULL(area);
-- 이미 컬럼의 기본값인 NULL 로 되어 있기 때문에 ADD 가 아닌 MODIFY 로 해야한다.

ALTER TABLE T_emp4 MODIFY (area CONSTRAINT emp4_area_nn NOT NULL);

-- #9007
-- t_emp4 테이블의 name 컬럼이 t_emp2 테이블의 name 컬럼의 값을 참조하도록 참조키 제약조건을 설정하세요
-- (외래키에서 이 경우  t_emp2 를 ‘부모(parent)테이블’ 이라 하고 t_emp4 를 ‘자식(child)테이블’ 이라 합니다)

ALTER TABLE T_emp4 ADD CONSTRAINT emp4_name_fk FOREIGN KEY(name) REFERENCES t_emp2(name);
-- SQL Error [2270] [42000]: ORA-02270: no matching unique or primary key for this column-list
-- 참조되는 부모테이블의 컬럼은 Primary Key 이거나 Unique 해야 한다!!!

-- 일단 부모테이블의 name을 UNIQUE 로 바꾼뒤 위의 쿼리를 다시 실행해보세욤
ALTER TABLE T_EMP2 ADD CONSTRAINT emp2_name_uk UNIQUE(name);

-- #9008
DROP TABLE t_emp3 CASCADE CONSTRAINT;
CREATE TABLE t_emp3 (
	NO NUMBER(4) , 
	name VARCHAR2(10) CONSTRAINT emp3_name_nn NOT null,
	jumin VARCHAR2(13) CONSTRAINT emp3_jumin_nn NOT NULL,
	area NUMBER(1) ,
	deptno VARCHAR2(6),
	CONSTRAINT emp3_no_pk PRIMARY KEY(no),
	CONSTRAINT emp3_jumin_uk UNIQUE(jumin),
	CONSTRAINT emp3_area_ck CHECK(area < 5),
	CONSTRAINT emp3_deptno_fk FOREIGN KEY(deptno) REFERENCES t_dept2(dcode) 
	ON DELETE CASCADE -- 부모 삭제되면 자식도 삭제 
	--	ON DELETE SET NULL -- 부모 삭제되면 NULL 값으로
);


-- #9009
ALTER TABLE t_emp4 DROP CONSTRAINT emp4_name_fk; -- 일단 기존 제약조건 삭제

ALTER TABLE t_emp4 
ADD CONSTRAINT emp4_name_fk FOREIGN KEY(name) 
	REFERENCES t_emp2(name)
	ON DELETE SET NULL ; -- 부모 삭제되면 자식은 null 로 변환
	
----------------------------------------------------
-- DISABLE NOVALIDATE

-- #9010
SELECT * FROM T_NOVALIDATE ;
SELECT * FROM T_VALIDATE ;

SELECT OWNER , CONSTRAINT_NAME, CONSTRAINT_TYPE, STATUS 
FROM USER_CONSTRAINTS
WHERE TABLE_name = 'T_VALIDATE';

SELECT OWNER , CONSTRAINT_NAME, CONSTRAINT_TYPE, STATUS 
FROM USER_CONSTRAINTS
WHERE TABLE_name = 'T_NOVALIDATE';

INSERT INTO T_VALIDATE VALUES(1,'DDD'); -- 처음에는 에러! PRIMARY KEY!

INSERT INTO T_NOVALIDATE VALUES(1,'DDD'); 

ALTER TABLE T_NOVALIDATE 
ENABLE NOVALIDATE CONSTRAINT SYS_C007033;

DELETE FROM T_NOVALIDATE  WHERE NAME = 'DDD';


	






