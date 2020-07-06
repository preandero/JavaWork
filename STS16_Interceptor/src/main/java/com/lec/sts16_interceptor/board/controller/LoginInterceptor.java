package com.lec.sts16_interceptor.board.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // session 객체 가져오기
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("id");

        // 컨트롤러 실행전 (Handler 실행전)
        System.out.println("[PreHandle] " + id);

        if(id == null){
            // 만약 로그인이 되어있지않다면, 로그인페이지로 , redirect

            // 직전 요청 url 을 세션에 기록
            String urlPrior =
                    request.getRequestURL().toString() + "?" + request.getQueryString();
            request.getSession().setAttribute("url_prior_login", urlPrior);


            response.sendRedirect(request.getContextPath() + "/user/login");
            return false;  // 더이상 컨트롤러 핸들러 진행하지 않도록 false 리턴

        }

        return true;  // true 리턴하면 컨트롤러 핸들러 진행


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 컨트롤러 실행 후 (View 직전)
        System.out.println("[PostHandle]");

        super.postHandle(request, response, handler, modelAndView);

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // View response 후

        System.out.println("[AfterCompletion]");
        super.afterCompletion(request, response, handler, ex);
    }
}
