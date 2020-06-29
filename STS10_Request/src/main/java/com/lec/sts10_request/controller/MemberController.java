package com.lec.sts10_request.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

    @RequestMapping(value = "/save")
    public String saveMember() {
        return "member/save";
    }

    @RequestMapping(value = "/load")
    public String loadMember(){
        return "member/load";
    }

//    @RequestMapping(value = "/search")
//    public String searchMember() {
//        return
//    }

}
