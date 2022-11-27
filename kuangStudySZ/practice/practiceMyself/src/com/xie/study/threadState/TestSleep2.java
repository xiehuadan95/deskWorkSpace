package com.xie.study.threadState;

import java.text.SimpleDateFormat;
import java.util.Date;

//模拟倒计时
public class TestSleep2 {
    public static void main(String[] args) {
       /* try {
            tenDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //打印当前系统时间  获取当前时间
        Date startTime=new Date(System.currentTimeMillis());
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                //更新时间 获取当前时间
                startTime=new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //模拟倒计时
    public static void tenDown() throws InterruptedException {
        int num=10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if(num<=0){
                break;
            }
        }

    }
}
