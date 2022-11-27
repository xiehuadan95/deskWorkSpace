package com.xie.study.operator;

public class Demo2 {
    public static void main(String[] args) {
        //++ --

        int a=10;
        int b=a++;
        System.out.println("a++="+a);
        int c=++a;
        System.out.println(b);
        System.out.println(c);
        System.out.println("a="+a);
        int d=3;
        d+=1;
        System.out.println(d);

        //Math
        //幂运算 2^3 2*2*2=8
        double pow=Math.pow(3,2);
        System.out.println(pow);
        // 需要double  int pow2=Math.pow(2,2);

        boolean flag=true;
        boolean flag2 = false;
        System.out.println("flag && flag2:"+(flag&&flag2));
        System.out.println("flag || flag2:"+(flag||flag2));
        System.out.println("!(flag && flag2):"+!(flag||flag2));















    }
}
