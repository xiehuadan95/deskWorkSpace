package com.xie.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //    1.要获取下载文件的路径
      //  String realPath=this.getServletContext().getRealPath("/b1.jpg");
        String realPath="D:\\IDEA2021\\IdeaWorkSpace\\kuangStudy\\javaweb-01-maven\\target\\classes\\b1.jpg";
        System.out.println("下载文件的路径："+realPath);
        //    2.下载文件名
        String fileName=realPath.substring(realPath.lastIndexOf("\\")+1);
        //3.设置想办法让浏览器能够支持下载我们需要的东西 URLEncoder.encode()给fileName转了一个码，让中文文件名编码，否则可能乱码
        resp.setHeader("Content-Disposition", "attachment;fileName="+ URLEncoder.encode(fileName,"UTF-8"));
//    4.获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
//    5.创建缓冲区
        int len=0;
        byte[] buffer = new byte[1024];
//    6.获取OutputStream对象
        ServletOutputStream out = resp.getOutputStream();
//    7.将FileOutputStream源写入到buffer缓冲区 8.使用OutputStream将缓冲区中的数据输出到客户端
        while((len=in.read(buffer))>0){
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
//
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
