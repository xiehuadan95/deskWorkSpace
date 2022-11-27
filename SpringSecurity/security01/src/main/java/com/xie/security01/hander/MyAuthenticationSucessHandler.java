package com.xie.security01.hander;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyAuthenticationSucessHandler implements AuthenticationSuccessHandler {
    private  String redirectUrl;

    public MyAuthenticationSucessHandler(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //重定向 是浏览器的行为
        response.sendRedirect(redirectUrl);
    }
}
