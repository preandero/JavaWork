package com.lec.sts18_security.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println("Login Success");

        // Authentication 객체를 이용해서 사용자가 가진 모든 권한을 문자열로 체크가능
        List<String> roleNames = new ArrayList<>();
        authentication.getAuthorities().forEach(authority -> {
            roleNames.add(authority.getAuthority());
        });

        System.out.println("ROLE NAMES: " + roleNames);

        // 만약 사용자가 ROLE_ADMIN 권한을 가졌다면 로그인 후 곧바로 /sample/admin 으로 이동
        if (roleNames.contains("ROLE_ADMIN")) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/sample/admin");
            return;
        }

        if (roleNames.contains("ROLE_MEMBER")) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/sample/member");
            return;
        }

        httpServletResponse.sendRedirect(httpServletRequest.getContextPath());
    }
}
