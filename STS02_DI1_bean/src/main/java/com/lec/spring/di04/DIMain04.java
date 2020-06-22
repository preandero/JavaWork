package com.lec.spring.di04;

import com.lec.spring.Student;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DIMain04 {

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:studentCtx.xml");
        System.out.println("컨테이너 생성");


        Student student = null;

        student = (Student) ctx.getBean("studentA", Student.class);

        System.out.println(student);


        student = (Student) ctx.getBean("studentB", Student.class);

        System.out.println(student);


        ctx.close();
    }

}
