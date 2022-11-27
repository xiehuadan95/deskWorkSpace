package com.xie.study.method;

import java.util.Scanner;



public class homeWork {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要进行的运算方式，可选择：+、-、*、/");
        String str = scanner.nextLine();
        switch (str){
            case "+":
                System.out.println("请输入要计算的第一个数字：");
                double a =scanner.nextDouble();
                System.out.println("请输入要计算的第二个数字：");
                double b=scanner.nextDouble();
                System.out.println(add(a,b));
                scanner.close();
                break;
            case "-":
                System.out.println("请输入要计算的第一个数字：");
                double x =scanner.nextDouble();
                System.out.println("请输入要计算的第二个数字：");
                double y=scanner.nextDouble();
                System.out.println(subtraction(x,y));
                scanner.close();
            break;
            case "*":
                System.out.println("请输入要计算的第一个数字：");
                double x1 =scanner.nextDouble();
                System.out.println("请输入要计算的第二个数字：");
                double y1=scanner.nextDouble();
                System.out.println(multiplication(x1,y1));
                scanner.close();
                break;
            case "/":
                System.out.println("请输入要计算的第一个数字：");
                double a1 =scanner.nextDouble();
                System.out.println("请输入要计算的第二个数字：");
                double b1=scanner.nextDouble();
                System.out.println(division(a1,b1));
                scanner.close();
                break;
            default:
                System.out.println("选择的运算方式不合法");
                scanner.close();
        }

    }

    private static double division(double a1, double b1) {
        if(b1==0.0){
            System.out.println("分母不能为0,输入有误");
            return 0.0;
        }
        return a1/b1;
    }

    private static double multiplication(double x1, double y1) {
        return x1*y1;
    }

    private static double subtraction(double a, double b) {
        return a-b;
    }

    private static double  add(double a,double b){
        return a+b;
   }
}
