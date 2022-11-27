package com.xie.study.oop;

public class Student extends Person {
    //字段
    private String name ="rose";
    //封装，属性私有
    private int age;
    private  char sex;

    public void go(){
        System.out.println("i can go");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //get  set 设置 获取 属性值 alt+insert快捷键
    //ctrl + H 打开继承树
    /*
      提高安全性；隐藏代码实现细节，统一接口，系统可维护性增加
     */
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>120 || age<0){
            this.age=3;}
        else {
            this.age = age;
        }
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    //方法
    public void study(){
        System.out.println(this.name+"在学习");
    }
    public void test(String name){
        System.out.println(name);
        System.out.println(this.name);
        System.out.println(super.name);
    }

   /* @Override
    public void print(){
        System.out.println("student");
    }*/
   /* public void test1(){
        print();
        this.print();
        super.print();
    }
    public void run(){
        System.out.println("i can run");
    }
    public Student(){
        //调用构造器必须放第一行
        //调用有参构造
        super("mike");
        System.out.println("student构造器执行了");
    }*/

}
