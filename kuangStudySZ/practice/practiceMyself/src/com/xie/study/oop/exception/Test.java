package com.xie.study.oop.exception;

import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) {
        int a=1;
        int b=0;

        new Test().test(a,b);
        //Ctrl + Alt+T 快捷键
       /* try {
            //throw抛出异常

            System.out.println(a/b);
        } catch (Exception e) {

            e.printStackTrace();
        }*/
    }
    //throws 在方法上抛出异常
    public void test(int a,int b) throws ArithmeticException{
        if(b==0){
            throw new ArithmeticException();
        }
    }



}
