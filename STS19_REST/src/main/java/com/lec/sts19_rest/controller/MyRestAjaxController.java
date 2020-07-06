package com.lec.sts19_rest.controller;


import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.AjaxWriteList;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/board")
public class MyRestAjaxController {


    @RequestMapping("/list.ajax/{uid}")
    public ResponseEntity<BWriteDTO> read(@PathVariable("uid") int uid){
        IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
        BWriteDTO dto = dao.selectByUid(uid);

        dao.incViewCnt(uid);

        if(dto == null) return new ResponseEntity(HttpStatus.NOT_FOUND);



        return new ResponseEntity<BWriteDTO>(dto, HttpStatus.OK);
    }



    @RequestMapping("/list.ajax/{page}/{PageRows}")
    public List<AjaxWriteList> listJSON(Model model, @PathVariable("page") int page, @PathVariable("PageRows") int pageRows){
        IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);

        List<AjaxWriteList> arr = new ArrayList<AjaxWriteList>();
        List<BWriteDTO> arrbr = null;

        // ajax response 에 필요한 값들
        StringBuffer message = new StringBuffer();
        String status = "FAIL";   // 기본 FAIL

        // 페이징 관련 세팅값들
//        int page = 1;  // 현재 페이지 (디폴트는 1 page)
//        int pageRows = 8;   // 한 '페이지' 에 몇개의 글을 리스트? (디폴트 8개)
        int writePages = 10;  // 한 [페이징] 에 몇개의 '페이지' 를 표시? (디폴트 10)
        int totalCnt = 0;    // 글은 총 몇개인지?
        int totalPage = 0;   // 총 몇 '페이지' 분량인지?

//        String param;
//
//        // page 값 : 현재 몇 페이지?
//        param = Integer.toString(page);
//        if(param != null && param.trim().length() != 0) {
//            try {
//                page = Integer.parseInt(param);
//            } catch(NumberFormatException e) {
//                // 예외 처리 안함
//            }
//        }
//
//        // pageRows 값 :  '한 페이지' 에 몇개의 글?
//        param = Integer.toString(pageRows);
//        if(param != null && param.trim().length() != 0) {
//            try {
//                pageRows = Integer.parseInt(param);
//            } catch(NumberFormatException e) {
//                // 예외 처리 안함
//            }
//        }


        // 글 전체 개수 구하기
        totalCnt = dao.countAll();


        // 총 몇 페이지 분량인가?
        totalPage = (int)Math.ceil(totalCnt / (double)pageRows);

        // 몇번재 row 부터 ?
        int fromRow = (page - 1) * pageRows + 1;  // ORACLE 은 1부터 ROWNUM시작
        //int fromRow = (page - 1) * pageRows;  // MySQL 은 0부터 시작

//        dao = C.sqlSession.getMapper(IWriteDAO.class);
        arrbr = dao.selectFromRow(fromRow, fromRow+pageRows);

        AjaxWriteList result = new AjaxWriteList();
        result.setList(arrbr);

        result.setCount(arrbr.size());

        result.setMessage(message.toString());

        // 페이징 할때 필요한 값들
        try {
            result.setPage(page);
            result.setTotalPage(totalPage);
            result.setWritePages(writePages);
            result.setPageRows(pageRows);
            result.setTotalCnt(totalCnt);
        } catch(Exception e) {
            // 개 무시..    /view.ajax 에선 페이징 관련 변수값들이 없다..
        }

        if(arrbr == null) {
            message.append("[리스트할 데이터가 없습니다]");
        } else {
            status = "OK";
            result.setStatus(status);
        }

        arr.add(result);


        return arr;
    }





}
