package com.lec.sts18_security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample/*")
public class SampleController {

    @GetMapping("/all")
    public void doAll(){
        System.out.println("doAll() : access everybody");
    }


    @GetMapping("/member")
    public void doMemeber(){
        System.out.println("doMember() : access member only");
    }

    @GetMapping("/admin")
    public void doAdmin(){
        System.out.println("doAdmin() : access admin only");
    }


}
