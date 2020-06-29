package com.lec.sts13_jdbc.board.command;

import com.lec.sts13_jdbc.board.beans.BWriteDAO;
import com.lec.sts13_jdbc.board.beans.BWriteDTO;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

public class BSelectCommand implements BCommand {


    @Override
    public void execute(Model model) {

        BWriteDAO dao = new BWriteDAO();
        List<BWriteDTO> dto = new ArrayList<BWriteDTO>();
        dto = dao.readByUid((Integer) model.getAttribute("uid"));

        model.addAttribute("list", dto);





    }
}
