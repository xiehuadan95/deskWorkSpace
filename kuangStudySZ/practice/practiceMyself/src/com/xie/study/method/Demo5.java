package com.xie.study.method;

public class Demo5 {
    public static void main(String[] args) {
        //2! 2*1 阶乘
        //3! 3*2*1
        //4! 4*3*2
        System.out.println(f(3));
    }

    public static int f(int n){

        if(n==1){
            return 1;
        }else {
            return n*f(n-1);
        }
    }
}
