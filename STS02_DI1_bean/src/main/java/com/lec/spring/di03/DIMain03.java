package com.lec.spring.di03;

import com.lec.spring.Score;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DIMain03 {

    public static void main(String[] args) {


        AbstractApplicationContext ctx =
                new GenericXmlApplicationContext("classpath:scoreCtx.xml");
        System.out.println("컨테이너 생성\n");

        Score score = null;

        score = ctx.getBean("myScore1",Score.class);
        System.out.println(score);

        score = (Score) ctx.getBean("myScore2");
        System.out.println(score);

    }



}
