package com.xie.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //放行什么情况下登录
        //登录页面也会放行
        if(request.getRequestURI().contains("Login")){
            return true;
        }
        if(session.getAttribute("userLoginInfo")!=null){
            return true;
        }
        //判断什么情况下没有登录 转发 去登录页
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }
}
