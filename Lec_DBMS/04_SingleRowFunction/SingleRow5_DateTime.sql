-- 날짜 함수
SELECT SYSDATE FROM dual;

-- 기본적인 날짜 연산
SELECT 
	SYSDATE "오늘",
	SYSDATE +1 "내일(24hr뒤)",
	SYSDATE -2 "그저께",
	SYSDATE + 1/24 "한시간 뒤"
FROM DUAL ;


-- 일자 차이 계산
SELECT 
	SYSDATE "오늘",
	TO_DATE('2020-03-16 09:00:00','YYYY-MM-DD hh:mi:ss'),
	ROUND(SYSDATE - TO_DATE('2020-03-16 09:00:00','YYYY-MM-DD hh:mi:ss'))
FROM DUAL ;

-- MONTHS_BETWEEN : 날짜 사이의 개월 수
SELECT 
	-- 규칙 1: 두 날짜중 큰 날짜를 먼저 써야 양수값으로 나옴
	MONTHS_BETWEEN('01-MAR-12','01-JAN-12')"양수값",
	MONTHS_BETWEEN('01-JAN-12','01-MAR-12')"음수값",
	-- 규칙 2: 두 날짜가 같은 달에 속해 있으면 특정 규칙으로 계산된 값
	MONTHS_BETWEEN('29-FEB-12','01-FEB-12')"2/29-2/01",
	MONTHS_BETWEEN('30-APR-12','01-APR-12') "4/30-4/01",
	MONTHS_BETWEEN('31-MAY-12','01-MAY-12') 
FROM DUAL ;

-- #4501
SELECT
	name "이름", 
	TO_CHAR(SYSDATE, 'YYYY-MM-DD') "오늘", 
	TO_CHAR(hiredate, 'YYYY-MM-DD') "입사일",
	TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(hiredate, 'YYYY') "근속연수",
	ROUND(MONTHS_BETWEEN(SYSDATE, hiredate), 1) "근속개월",
	ROUND(SYSDATE - hiredate, 1) "근속일"
FROM
	t_professor;
	
-- ADD_MONTH() 개월 추가
SELECT SYSDATE, ADD_MONTHS(SYSDATE,3 ) FROM DUAL ;

SELECT 
	SYSDATE,
	LAST_DAY(SYSDATE)"이번달 마지막날",
	NEXT_DAY(SYSDATE,'MON')"다음 월요일" 
FROM DUAL ;

-- 날짜의 ROUND() 함수  ,  하루의 반은 정오 12:00:00 이다. 이를 넘어서면 다음 날짜
-- 날짜의 TRUNC() 함수,  무조건 당일 출력.
-- 원서 접수나 상품 주문 등에서 오전까지 접수된 건은 당일 접수 처리. 오후접수는 익일 처리 등에서 사용.
SELECT 
	SYSDATE,
	ROUND(SYSDATE),
	TRUNC(SYSDATE)
FROM DUAL ;
