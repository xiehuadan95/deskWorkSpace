package com.xie.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//编写Servlet类 httpservlet实现了servlet接口
public class HelloServlet extends HttpServlet {
    //重写 doget 和dopost方法，可以用dopost方法中调用doget（），就可以实现复用
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取前端参数
        String method=req.getParameter("method");
        if(method.equals("add")){
            req.getSession().setAttribute("msg","执行了add方法");
        }
        if(method.equals("delete")){
            req.getSession().setAttribute("msg","执行了delete方法");
        }
        //2.调用业务层

        //3.视图转发或者重定向 这里用用转发，跳转路径到自己定义的页面去
        // 转发的时候继续将参数req ,resp携带过去
        req.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(req,resp);
        //resp.sendRedirect(); 重定向
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
