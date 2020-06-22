package com.lec.spring.profile4.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProfileMain4 {
    public static void main(String[] args) {

        String config = "run";

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();


        ctx.getEnvironment().setActiveProfiles(config);

        ctx.load("appCtx4_dev.xml", "appCtx4_run.xml");

        ctx.refresh();

        ServiceInfo info = ctx.getBean("serverInfo",ServiceInfo.class);
        System.out.println("ip : " + info.getIpNum());
        System.out.println("port : " + info.getPortNum());

        ctx.close();
    }
}
