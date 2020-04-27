SELECT * FROM T_PROFESSOR ;

-- null 값과의 연산 결과는 null이다. 
SELECT name, pay, BONUS ,pay + BONUS 
FROM T_PROFESSOR ; 
 
-- 그룹함수에서는 동작, null 은 연산에서 제외되어 동작. 
SELECT SUM(pay), sum(BONUS) 
FROM T_PROFESSOR ; 

-- nvl() 함수 
SELECT name, pay, BONUS , 
		pay + BONUS 총지급액, 
		pay + NVL(bonus,0) 총지급액 
FROM T_PROFESSOR ; 
 
SELECT name, hiredate 
FROM T_PROFESSOR ; 


-- #4201
SELECT NAME ,PAY ,NVL(bonus,0) BONUS , PAY * 12 +NVL(bonus,0) 연봉 
FROM T_PROFESSOR ;
WHERE deptno = 101;

-- #4202
SELECT NAME ,PAY ,
		NVL2(bonus,BONUS ,0) BONUS , 
		NVL2(bonus,PAY * 12 +BONUS ,pay *12) 연봉 
FROM T_PROFESSOR ;
WHERE deptno = 101;
