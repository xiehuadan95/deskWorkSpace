package com.xie.study.oop.exception;

/*
自定义异常
 */
public class MyException extends Exception{

     //传递数字>10;
        public int detail;
        public MyException (int a){
            this.detail=a;
        }
        //toString
        @Override
        public String toString(){
            return "MyException"+detail+"==>";
        }

}
