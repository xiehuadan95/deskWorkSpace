package com.xie.study.method;

public class Demo2 {
    public static void main(String[] args) {
        add();
        add("jack","rose");

    }
    //方法的重载
    public static void add(String str,String str2){
        String result =str+str2;
        System.out.println("两个字符串相加的结果："+result);
    }
    public static void add() {
        System.out.println("=======打印九九乘法表=======");
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + (j * i) + "\t");
                if (i == j) {
                    System.out.println();
                    continue;
                }
            }
        }
    }
    public static double add(double d1,double d2){
        double result=d1+d2;
            return result;
    }
    public static int add(int a,int b){
        int result=a+b;
        return result;
    }


    }


