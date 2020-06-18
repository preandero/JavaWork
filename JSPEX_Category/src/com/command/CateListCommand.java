package com.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.CategoryDAO;
import com.lec.beans.CategoryDTO;

public class CateListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		
		CategoryDAO dao = new CategoryDAO();
		CategoryDTO [] arr = null;
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";   // 기본 FAIL
		
		String depth = request.getParameter("depth");
		
		// 유효성 검사
//		if(depth == null) {
//			message.append("[유효하지 않은 parameter 0 or null]");
//		} else {			
			try {
				
				arr = dao.selectByDO();  
				
				if(arr == null) {
					message.append("[해당 데이터가 없습니다]");
				} else {
					status = "OK";
				}
				
			} catch (Exception e) {
				message.append("[예외발생:" + e.getMessage() + "]");
			}// end try
//		} // end if

		request.setAttribute("category", arr);
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());
		
		
		
	}

}
