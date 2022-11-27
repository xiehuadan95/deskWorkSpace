package com.xie.study.lambda;


public class Test02 {
    public static void main(String[] args) {
        ILove love;
      /*  //1.lambda表达式
        ILove love = (int a) -> {
            System.out.println("i love you-->" + a);
        };
        //简化1.去掉参数类型
        love =(a)-> {
            System.out.println("i love you-->" + a);
        };*/
        //简化2.简化括号
        love = (int a,int b)->{
            System.out.println("i love you-->" + a+""+b);
        };
        //简化3.去掉花括号
        love=(a,b)-> System.out.println("i love you-->"+a+"+"+b);
        //总结 ：
        //lambda 表达式 只能有一行代码的情况下 才能简化称为一行，如果有多行，那么就用代码块包裹
        //2.前提：必须是函数式接口
        //4.多个参数也可以去掉参数类型，要去掉都去掉，必须加上括号
        love.love(521,20);
    }
}

interface ILove {
    void love(int a,int b);
}

