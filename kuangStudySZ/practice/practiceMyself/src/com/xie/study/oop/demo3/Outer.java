package com.xie.study.oop.demo3;

public class Outer {
    private static int id=10;
    public void method(){
        //局部内部类
        class Inner{
            public void in(){

            }
        }
    }
    public void out(){
        System.out.println("这是外部类的方法");
    }
   public static class Inner{
        public  void in(){
            System.out.println("这是内部类的方法");
        }
        //获得外部类的私有属性
       public static void getId(){
           System.out.println(id);
       }

    }

}
