package com.lec.sts10_request.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

    @RequestMapping(value = "/list")
    public String listboard(){
        return "/board/list_board";
    }

    @RequestMapping(value = "/write")
    public String writeboard(){
        return "/board/write_board";
    }

    @RequestMapping(value = "/view")
    public String viewboard(){
        return "/board/view_board";
    }

    @RequestMapping(value = "/update")
    public String updateboard(){
        return "/board/update_board";
    }

    @RequestMapping(value = "/delete")
    public String deleteboard(){
        return "/board/delete_board";
    }
}
