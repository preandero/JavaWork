
/* Drop Tables */

DROP TABLE test_member CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE test_member
(
	mb_no number,
	mb_name varchar2(40) NOT NULL,
	mb_birthdate date
);

-- sequence 
DROP SEQUENCE TEST_MEMBER_SEQ ;
CREATE SEQUENCE test_member_seq;

SELECT * FROM test_member;

DELETE FROM TEST_MEMBER ;


