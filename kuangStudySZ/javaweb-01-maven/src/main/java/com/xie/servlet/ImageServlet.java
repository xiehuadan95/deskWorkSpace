package com.xie.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如何让浏览器3秒自动刷新一次
        resp.setHeader("refresh", "3");
        //在内存中创建一个图片
        BufferedImage bufferedImage = new BufferedImage(80,20 ,BufferedImage.TYPE_INT_RGB );
        //得到图片 相当于一支笔
        Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
        //设置图片的背景颜色
        g.setColor(Color.white);
        //填充的范围
        g.fillRect(0,0,80,20);
        //给图片写数据
        //给画笔更换了颜色
        g.setColor(Color.BLUE);
        g.setFont(new Font(null,Font.LAYOUT_NO_LIMIT_CONTEXT, 20));
        g.drawString(makeNum(),0,20);
        //告诉浏览器这个请求用图片的方式打开 text/
        resp.setContentType("image/jpeg");
        //网站存在缓存 不让浏览器缓存
        resp.setDateHeader("expires", -1);
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");
        //把图片写给浏览器
        ImageIO.write(bufferedImage,"jpg",resp.getOutputStream());



    }
    //生成随机数
    private String makeNum(){
        Random random = new Random();
        //5位数
        String num=random.nextInt(99999)+"";
        StringBuffer sb = new StringBuffer();
        //保证这个数一定是5位，如果长度不够5位用0去填充
        for (int i = 0; i < 5-num.length(); i++) {
            sb.append("0");
        }
        String s = sb.toString() + num;
        return num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
