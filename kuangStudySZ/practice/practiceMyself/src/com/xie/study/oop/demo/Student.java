package com.xie.study.oop.demo;

//static

public class Student {

    private static int age;
    private  double score;
    public void run(){

    }
    public static  void go(){

    }

    public static void main(String[] args) {
        Student s1=new Student();
        System.out.println(Student.age);
        //可以用实例对象调用
        System.out.println(s1.age);
        Student.go();
        new Student().run();
    }


}
