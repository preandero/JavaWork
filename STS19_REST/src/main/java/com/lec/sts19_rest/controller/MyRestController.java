package com.lec.sts19_rest.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lec.sts19_rest.board.beans.EmployeeListVO;
import com.lec.sts19_rest.board.beans.EmployeeVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/MyRest")
public class MyRestController {
	
	@RequestMapping("/")
	public String helloTEXT() {
		return "Hello REST";
	}
	
//	@RequestMapping("/helloJSON")
//	public BWriteDTO helloJSON() {
//		BWriteDTO dto =
//				new BWriteDTO(100, "안녕하세요", "REST", "JSON이당!",
//						123, new Timestamp(10000));
//
//		return dto;
//	}
	
	// JSON 데이터 <-- 자바 List<>
//	@RequestMapping("/listJSON")
//	public List<BWriteDTO> listJSON(){
//		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
//		return dao.select();
//	}
//
//	// JSON 데이터 <-- 자바 배열
//	@RequestMapping("/arrJSON")
//	public BWriteDTO[] arrJSON(){
//		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
//		List<BWriteDTO> list =  dao.select();
//		BWriteDTO [] arr = new BWriteDTO[list.size()];
//		return list.toArray(arr);
//	}
//
//	// JSON 데이터 <-- 자바 Map<k, v>
//	@RequestMapping("/mapJSON")
//	public Map<Integer, BWriteDTO> mapJSON(){
//		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
//		List<BWriteDTO> list =  dao.select();
//
//		Map<Integer, BWriteDTO> map = new HashMap<Integer, BWriteDTO>();
//
//		for(BWriteDTO dto : list) {
//			map.put(dto.getUid(), dto);
//		}
//
//		return map;
//	}

	@RequestMapping("/helloXML")
	public EmployeeVO hellXML() {
		return
				new EmployeeVO(100, "홍길동", 200 , new int[]{10,20,30}, 34.2);
	}



	@RequestMapping("listXML")
	public EmployeeListVO listXML(){
		EmployeeListVO employees = new EmployeeListVO();

		EmployeeVO emp1 = new EmployeeVO(1, "김재현", 24 , new int[]{78,67,92}, 34.2);
		EmployeeVO emp2 = new EmployeeVO(1, "김재현", 24 , new int[]{78,67,92}, 34.2);
		EmployeeVO emp3 = new EmployeeVO(1, "김재현", 24 , new int[]{78,67,92}, 34.2);

		employees.getEmployees().add(emp1);
		employees.getEmployees().add(emp2);
		employees.getEmployees().add(emp3);


		return employees;

	}

	@RequestMapping("/read/{uid}")
	public ResponseEntity<BWriteDTO> read(@PathVariable("uid") int uid){
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		BWriteDTO dto = dao.selectByUid(uid);

		if(dto == null) return new ResponseEntity(HttpStatus.NOT_FOUND);



		return new ResponseEntity<BWriteDTO>(dto, HttpStatus.OK);
	}

	
	
	
	
	
	
	
}






















