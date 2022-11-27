package com.xie.study.scanner;

import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        //我们输入多个数字，并求其总和与平均值，每输入一个数字用回车确认，通过输入非数字来结束输入并输出执行结果
        Scanner scanner = new Scanner(System.in);

        //总和
        double sum=0;
        //计算输入了多少个数字
        int m=0;

        //通过循环判断是否还有输入，并在里面对每一次进行求和统计
        while (scanner.hasNextDouble()){
            double x = scanner.nextDouble();
            m++;
            sum+=x;
            System.out.println("你输入了第"+m+"个数据，当前的结果sum="+sum);
        }
        System.out.println("个数："+m+"总和："+sum);
        System.out.println("个数的平均值是："+(sum/m));

        scanner.close();


    }
}
