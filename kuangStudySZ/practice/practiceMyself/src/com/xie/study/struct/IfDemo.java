package com.xie.study.struct;

import java.util.Scanner;

public class IfDemo {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入内容：");
        String s=scanner.nextLine();

        if(s.equals("hello")){
            System.out.println(s);
        }else{
            System.out.println("End");
        }


        scanner.close();



    }
}
