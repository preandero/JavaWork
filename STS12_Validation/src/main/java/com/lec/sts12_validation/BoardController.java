package com.lec.sts12_validation;


import com.lec.beans.WriteDTO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @RequestMapping("write.do")
    public String write(){
        return "board/write";
    }

    @RequestMapping("writeOk.do")
    public String writeOk(@ModelAttribute("w") @Valid WriteDTO dto,
                          BindingResult result){

        System.out.println("writeOk():" + dto.getUid() + ":" + dto.getName());
//        System.out.println("에러개수: " + result.getErrorCount());
//        System.out.println("validate전");showErrors(result);

        String page = "board/writeOk";

//        BoardValidator validator = new BoardValidator();
//        validator.validate(dto, result);
        System.out.println("validate후"); showErrors(result);

        if(result.hasErrors()){
            page = "board/write";
        }

        return page;
    }


    // error 에 담겨 있는 에러들을 다 출력해보기
    public void showErrors(Errors errors){
        if(errors.hasErrors()){
            System.out.println("에러 개수 : " + errors.getErrorCount());
            System.out.println("\t[field]\t|[code]");
            List<FieldError> errList = errors.getFieldErrors();

            for (FieldError err : errList){
                System.out.println("\t" + err.getField() + "\t|" + err.getCode());
            }
        } else
        {
            System.out.println("에러 없음");
        }
    }

    // 이 컨트롤러 클래스의 handler 에서 폼 데이터를 바인딩 할때 검증하는 개체 지정
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setValidator(new BoardValidator());
    }


}
