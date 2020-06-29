package com.lec.sts13_jdbc.board.command;

import com.lec.sts13_jdbc.board.beans.BWriteDAO;
import com.lec.sts13_jdbc.board.beans.BWriteDTO;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BDeleteCommand implements BCommand {
    @Override
    public void execute(Model model) {

        BWriteDAO dao = new BWriteDAO();

        int result = dao.deleteByUid((Integer) model.getAttribute("uid"));

        model.addAttribute("result", result);

    }
}
