package com.lec.spring.environment;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;

public class EnvMain {
    public static void main(String[] args) {

        System.out.println("Main 시작");

        // Context -> Environment -> PropertySources
        ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();

        ConfigurableEnvironment env = ctx.getEnvironment();

        MutablePropertySources propertySources = env.getPropertySources();

        //  propertySources 에 propertySource 추가

        try {
            // propertySource 하나를 생성하여 PropertySources 에 추가 : addLast() 끝에 추가

            propertySources.addLast(
                    new ResourcePropertySource("classpath:admin.auth"));

            System.out.println(env.getProperty("admin.id"));
            System.out.println(env.getProperty("admin.pw"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
        gCtx.load("classpath:appCtx1.xml");
        gCtx.refresh();

        AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);

        System.out.println(adminConnection.getAdminId());
        System.out.println(adminConnection.getAdminPw());



    }
}
