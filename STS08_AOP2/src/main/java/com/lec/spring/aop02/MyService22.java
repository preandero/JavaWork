package com.lec.spring.aop02;

import com.lec.spring.beans.Service;

public class MyService22 extends Service {
    public void doAction() {

        // 공통기능이 없다!?

        printInfo(); // 핵심 기능

    }
}
