package com.xie;

import com.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //注册servlet
        //解决乱码
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        //把文档变为html
        resp.setContentType("text/html;charset=utf-8");
        //得到Session
        HttpSession session = req.getSession();

        //给Session 存入东西 节点 同时可以存对象，比如Person
        // session.setAttribute("name","rose");
        session.setAttribute("name", new Person("jack", 2, 20));
        //获取session的Id
        String id = session.getId();
        //判断Session是不是新创建的  .write为写出来，print为打印
        boolean aNew = session.isNew();
        if (aNew) {
            resp.getWriter().write("Session 创建成功！id为" + id);
        } else {
            resp.getWriter().write("session已经在服务器中存在！id：" + id);
        }
        //session创建的时候做了什么事情
//       Cookie cookie= new Cookie("JESSIONID",id);
//        resp.addCookie(cookie);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
