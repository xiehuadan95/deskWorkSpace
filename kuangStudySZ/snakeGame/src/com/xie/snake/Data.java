package com.xie.snake;

import javax.swing.*;
import java.net.URL;

//存放外部数据
public class Data {
    //头部图片 URL 类 获取资源 定位图片地址
    public static URL headerURL=Data.class.getResource("/static/header.png");
    //ImageIcon 图片
    public static ImageIcon header=new ImageIcon(headerURL);

    //蛇头上下左右
    public static URL snakeuURL=Data.class.getResource("/static/up.png");
    public static URL snakedURL=Data.class.getResource("/static/down.png");
    public static URL snakelURL=Data.class.getResource("/static/left.png");
    public static URL snakerURL=Data.class.getResource("/static/right.png");
    public static ImageIcon up=new ImageIcon(snakeuURL);
    public static ImageIcon down=new ImageIcon(snakedURL);
    public static ImageIcon left=new ImageIcon(snakelURL);
    public static ImageIcon right=new ImageIcon(snakerURL);

    //身体
    public static URL bodyURL=Data.class.getResource("/static/body.png");
    public static ImageIcon body=new ImageIcon(bodyURL);
    //食物
    public static URL foodURL=Data.class.getResource("/static/food.png");
    public static ImageIcon food=new ImageIcon(foodURL);
}
