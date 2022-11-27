package com.xie.study.scanner;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        //创建一个扫描对象
        Scanner scanner = new Scanner(System.in);
        System.out.println("使用next方式接收");
        //判断用户有没有输入字符串
        if(scanner.hasNext()){
            //使用next方式接收
            String str=scanner.next();
            System.out.println("输入的内容为："+str);
        }
        //next()不能得到空格以后的字符串内容  而nextLine() 以回车为结束符 可以得到空格内容  也可以不用If判断

        Scanner scanner1 = new Scanner(System.in);
        if(scanner1.hasNextLine()){
            String str = scanner1.nextLine();
            System.out.println("输入的内容为："+str);
        }
        //io流的用完要关掉
        scanner.close();
        scanner1.close();
    }

}
