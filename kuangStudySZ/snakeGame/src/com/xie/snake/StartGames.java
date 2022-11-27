package com.xie.snake;

import javax.swing.*;

//awt  只是一个窗口 还需要一个面板Jpanel
public class StartGames {
    public static void main(String[] args) {
        //1.绘制一个静态窗口JFrame
        JFrame frame = new JFrame("媛媛贪吃蛇小游戏");
        //设置界面大小 x y 0 0点在电脑的左上角 相对位置
        frame.setBounds(50, 50, 900, 720);
        //窗口大小则不可以改变 如果是false  如果不需要 可以不设置则可以改变大小
        frame.setResizable(false);
        //设置关闭时间，游戏可以关闭了
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //2.将画板添加到窗口上
        frame.add(new GamePanel());
        //让窗口能够展现出来
        frame.setVisible(true);


    }
}
