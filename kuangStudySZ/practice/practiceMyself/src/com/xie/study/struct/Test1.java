package com.xie.study.struct;

public class Test1 {
    public static void main(String[] args) {
        //打印三角形
        for (int i = 1; i <=5; i++) {
            for(int j=5;j>=i;j--){
                System.out.print("*");
            }
            System.out.println();

        }
    }

}
