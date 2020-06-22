package com.lec.spring.di05;

import com.lec.spring.Score;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DIMain05 {

    public static void main(String[] args) {

        AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:studentCtx2.xml");

        Score score = null;

        score = (Score) ctx.getBean("score1");
        System.out.println(score);




        System.out.println(ctx.getBean("score2"));




        System.out.println(ctx.getBean("stu1"));
        System.out.println(ctx.getBean("stu2"));


        ctx.close();

    }
}
