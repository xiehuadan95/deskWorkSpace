package com.xie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//保存用户上一次访问的时间
public class CookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //服务器，告诉你，你来的时间，把这个时间封装成为一个信件，你下次带来，我就知道你来了

        //解决中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();
        //cookie ,服务器端从客户端获取  这里返回数组，客户端请求携带过去给服务器 可能存在多个
        Cookie[] cookies = req.getCookies();
        //判断cookie是否存在 第一次肯定服务器没有值
        if(cookies!=null){
            //如果存在怎么办？ 数组遍历
            out.write("你上一次访问的时间是：");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie=cookies[i];
                //获取cookie的名字
                if(cookie.getName().equals("lastLoginTime")){
                    //获取cookie中的值 解析为长整型
                    String date = cookie.getValue();
                    long lastLoginTime=Long.parseLong(date);
                    //变成时间
                    Date date1=new Date(lastLoginTime);
                    //本地时间格式化 转换为字符串
                    out.write(date1.toLocaleString());
                }
            }
            
        }else{
            out.write("这是你第一次访问本站");
        }
        //服务器给客户端相应一个cookie 创建一个时间放入cookie
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+"");
        //给cookie设置有效期为1天
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
doGet(req,resp);
    }
}
