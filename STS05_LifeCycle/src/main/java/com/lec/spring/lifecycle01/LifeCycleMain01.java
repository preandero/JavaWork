package com.lec.spring.lifecycle01;


import com.lec.beans.Score;
import org.springframework.context.support.GenericXmlApplicationContext;

public class LifeCycleMain01 {

    public static void main(String[] args) {
        System.out.println("Main 시작");

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();

        System.out.println("컨테이너 생성 완료");


        ctx.load("classpath:appCtx01_A.xml");

        System.out.println("설정 load 완료" );

        ctx.refresh();
        System.out.println("컨테이너 refresh 완료");

        Score score1 = ctx.getBean("score1",Score.class);
        System.out.println(score1);

        ctx.close();
    }
}
