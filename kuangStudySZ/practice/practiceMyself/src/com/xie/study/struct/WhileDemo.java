package com.xie.study.struct;

public class WhileDemo {
    public static void main(String[] args) {
        //计算1-100总和
        int i = 0;
        int sum = 0;

        while (i < 100) {
            i++;
            sum += i;
        }

        System.out.println("总和为：" + sum + "循环了多少次:" + i);
        do {
            i++;
            sum += i;
        } while (i > 100);



    }
}
