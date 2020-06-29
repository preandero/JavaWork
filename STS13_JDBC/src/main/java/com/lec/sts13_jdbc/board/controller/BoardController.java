package com.lec.sts13_jdbc.board.controller;

import com.lec.sts13_jdbc.board.command.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.sts13_jdbc.board.C;
import com.lec.sts13_jdbc.board.beans.BWriteDTO;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private BCommand command;
	private JdbcTemplate template;
	
	public BoardController() {
		super();
		System.out.println("BoardController() 생성");
	}

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		System.out.println("setTemplate() 호출");
		this.template = template;
		C.template = template;
	}
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		command = new BListCommand();
		command.execute(model);
		return "board/list";
	}
	
	@RequestMapping("/write.do")
	public String write(Model model) {
		return "board/write";
	}
	
	@RequestMapping(value = "/writeOk.do", method = RequestMethod.POST)
	public String writeOk(BWriteDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new BWriteCommand().execute(model);
		return "board/writeOk";
	}

	@RequestMapping("/view.do")
	public String view(int uid, Model model ){
		model.addAttribute("uid",uid);
		command = new BViewCommand();
		command.execute(model);
		return "board/view";
	}

	@RequestMapping("/update.do")
	public String update(int uid, Model model){
		model.addAttribute("uid",uid);
		new BSelectCommand().execute(model);
		return "board/update";

	}


	@RequestMapping(value = "/updateOk.do", method = RequestMethod.POST)
	public String updateOk(BWriteDTO dto, Model model){
			model.addAttribute("dto",dto);
			new BUpdateCommand().execute(model);
		return "board/updateOk";
	}

	@RequestMapping("/deleteOk.do")
	public String deleteOk(int uid, Model model){
		model.addAttribute("uid",uid);
		new BDeleteCommand().execute(model);
		return "board/deleteOk";
	}



	
	
}













