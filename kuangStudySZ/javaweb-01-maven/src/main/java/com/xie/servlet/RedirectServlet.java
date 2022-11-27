package com.xie.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
重定向和转发的区别：
相同：页面都会实现跳转
不同：请求转发的时候url不会发生变化（转发
  重定向 url会发生变化
 */
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //重定向
        /*resp.setHeader("location", "/java/img");
        resp.setStatus(302);*/
        resp.sendRedirect("/java/img");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
