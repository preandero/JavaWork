package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

import common.D;

public class ViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		
		WriteDAO dao = new WriteDAO();
		WriteDTO[] arr = null;
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		
			try {
				arr = dao.readByUid(uid);
				
				request.setAttribute("view", arr);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		
	}

}
