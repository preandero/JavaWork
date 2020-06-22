package com.lec.spring.aop02;


// Aspect : Advisor 들을 모아놓은 객체
// Advisor : Advice + Pointcut
// Advice : 공통기능(메소드)
// Pointcut :


import com.lec.spring.beans.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

// 이 클래스가 Aspect 역할을 할 클래스 임을 명시
@Aspect
public class LogAspect {


    @Pointcut("within(com.lec.spring.aop02.*)")
    public void pc1() {}

    @Pointcut("within(com.lec.spring.aop02.*)")
    public void pc2() {}





    @Before("pc1()") // PointCut
    public void beforeAdvice() {
        System.out.print("[Before] ");
        new Logger().logIn();

    }

//    @After("within(com.lec.spring.aop02.*)")
//    @After("execution(* com.lec.spring.aop02.MyService22.*(..))")
//    @After("pc2()")
    @After("execution(* com.lec.spring.aop02.*2.*(..))")
    public void afterAdvice(){
        System.out.println("[After]");
        new Logger().logOut();
    }


    // Around advice : 메소드 실행을 제어하는 가장 강력한 코드
    //  직접 해당 메소드를 호출하고 결과나 예외 처리도 가능.
    @Around("within(com.lec.spring.aop02.*)")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

        String signatureStr = joinPoint.getSignature().toShortString();

        // joinPoint 메소드 수행 전
        System.out.println("[Around] " + signatureStr + " 시작");
        long st = System.currentTimeMillis();

        // joinPoint 메소드 수행
        Object obj = null;
        try {
            obj = joinPoint.proceed();
        return obj;

        }  finally {
            long et = System.currentTimeMillis();
            System.out.println("[Around] " + signatureStr + "종료, 경과시간: " + (et - st));

        }

        // joinPoint 메소드 수행 후



    }


}
