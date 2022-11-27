package com.xie.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


//最后把画板加入到Frame  监听键盘 接口
public class GamePanel extends JPanel implements KeyListener, ActionListener {
    //蛇的长度
    int length;
    //蛇的坐标 x y
    int[] snakeX= new int[600];
    int[] snakey= new int[500];
    //方向 默认右 L U D
    String fx;
  //游戏是否开始
    boolean isStart=false;
    //定时器 100毫秒监听一下 实现ActiongListener接口
    Timer timer=new Timer(100, this);
    //三 定义一个食物
    int foodx;
    int foody;
    Random random =new Random();
    //死亡判断
    boolean isFail=false;
    //积分系统
    int score;

    //利用构造器 调用蛇的初始化方法
    public GamePanel(){
        init();
        //获取键盘的监听事件
        //让键盘焦点在 这个GamePanel对象上 获取焦点
        this.setFocusable(true);
        //添加一个监听，实现了监听接口的类，this这个类
        this.addKeyListener(this);
        timer.start();
    }

    //初始化 蛇在哪个位置
    public void init(){
        length=3;
        fx="R";
        //头部坐标
        snakeX[0]=100;snakey[0]=100;
        //第一个身体坐标
        snakeX[1]=75;snakey[1]=100;
        //第二个身体坐标
        snakeX[2]=50;snakey[2]=100;

        foodx = 25+25*random.nextInt(34);
        foody = 75+25*random.nextInt(24);
        score=0;

    }



    //画板； 画界面 画蛇 Graphics g:画笔
    @Override
    protected void paintComponent(Graphics g) {
        //调用父类，清屏
        super.paintComponent(g);
        //这个类 设置背景的颜色
        this.setBackground(Color.WHITE);
        //头部的广告栏 画我们的图标  画在哪个component 组件，画笔：g
        Data.header.paintIcon(this, g, 25, 11);
        //绘制游戏区域 填充一个矩形区域
        g.fillRect(25,75,850,600);
     //先画一条静态小蛇 设置好蛇的属性
       /* Data.right.paintIcon(this,g,snakeX[0],snakey[0]);
        Data.body.paintIcon(this,g,snakeX[1],snakey[1]);
        Data.body.paintIcon(this,g,snakeX[2],snakey[2]);*/
        if(fx.equals("R")){
            Data.right.paintIcon(this,g,snakeX[0],snakey[0]);
        }else if(fx.equals("L")){
            Data.left.paintIcon(this,g,snakeX[0],snakey[0]);
        }else if(fx.equals("U")){
            Data.up.paintIcon(this,g,snakeX[0],snakey[0]);
        }else if(fx.equals("D")){
            Data.down.paintIcon(this,g,snakeX[0],snakey[0]);
        }

        //用for循环动起来  //蛇的身体长度 通过我们的length来控制
        for (int i = 1; i <length ; i++) {
            Data.body.paintIcon(this,g,snakeX[i],snakey[i]);
        }
        //画食物
        Data.food.paintIcon(this,g,foodx,foody);
        //画积分
        g.setColor(Color.BLACK);
        g.setFont(new Font("微软雅黑", Font.BOLD, 18));
        g.drawString("长度："+length, 30, 35);
        g.drawString("分数："+score,30 , 50);
       //游戏提示：是否开始
        if(isStart==false){
            //画一个文字，String //设置画笔颜色
            g.setColor(Color.WHITE);
            //设置字体 大小 内容及坐标
            g.setFont(new Font("微软雅黑", Font.BOLD,40));
            g.drawString("按下空格开始游戏", 300, 300);
        }
        //失败提醒
        if(isFail==true){
            //画一个文字，String //设置画笔颜色
            g.setColor(Color.RED);
            //设置字体 大小 内容及坐标
            g.setFont(new Font("微软雅黑", Font.BOLD,40));
            g.drawString("游戏失败，按下空格重新开始", 200, 300);
        }



    }
    //接收键盘的输入：监听
    @Override
    public void keyPressed(KeyEvent e) {
        //按下 即可 未释放
        //获取按下的键盘是哪个键 按下空格 更改isStart值
        int keyCode = e.getKeyCode();
        if(keyCode==KeyEvent.VK_SPACE){
            if(isFail){
                isFail=false;
                init();
            }else{
            isStart=!isStart;
            }
            //刷新界面
            repaint();
        };
      //键盘控制走向
        if(keyCode==KeyEvent.VK_LEFT){
            fx="L";
        }else if(keyCode==KeyEvent.VK_UP){
            fx="U";
        }else if(keyCode==KeyEvent.VK_DOWN){
            fx="D";
        }else if(keyCode==KeyEvent.VK_RIGHT){
            fx="R";
        }


    }
    //定时器
   //执行定时操作
    @Override
    public void actionPerformed(ActionEvent e) {
        //如果游戏处于开始状态,且游戏没有结束
        if(isStart && isFail==false){
            //除了脑袋，身体都向前移动
            for (int i = length-1; i >0 ; i--) {
                snakeX[i]=snakeX[i-1];
                snakey[i]=snakey[i-1];
            }
            //通过控制方向让头部移动
            if(fx.equals("R")){
                snakeX[0]=snakeX[0]+25;
                //边界判断
                if(snakeX[0]>850){
                    snakeX[0]=25;
                }
            }else if(fx.equals("L")){
                snakeX[0]=snakeX[0]-25;
                if(snakeX[0]<25){
                    snakeX[0]=850;
                }
            }else if(fx.equals("U")){
                snakey[0]=snakey[0]-25;
                if(snakey[0]<75){
                    snakey[0]=650;
                }
            }else if(fx.equals("D")){
                snakey[0]=snakey[0]+25;
                if(snakey[0]>650){
                    snakey[0]=75;
                }
            }
            //如果头和食物坐标重合
            if(snakeX[0]==foodx && snakey[0]==foody){

                length++;
                score+=10;
                //重新生成食物
                foodx = 25+25*random.nextInt(34);
                foody = 75+25*random.nextInt(24);

            }
            //结束判断
            for (int i = 1; i <length ; i++) {
                if(snakeX[0]==snakeX[i] && snakey[0]==snakey[i]){
                isFail=true;
                }
            }

            //刷新界面
            repaint();
        }
        //时间动起来
        timer.start();
    }





    @Override
    public void keyTyped(KeyEvent e) {
     //键盘按下 弹起来
    }
    @Override
    public void keyReleased(KeyEvent e) {
      //释放某个键的时候
    }

}
