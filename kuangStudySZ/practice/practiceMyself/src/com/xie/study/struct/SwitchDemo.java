package com.xie.study.struct;

import java.util.Scanner;

public class SwitchDemo {
    public static void main(String[] args) {
        // 可以用 byte short int char String(字面量 常量) enum
        //分数
        char grade='c';
        switch (grade){
            case 'a':
                System.out.println("优秀");
                break;
            case 'b':
                System.out.println("良");
                break;
            case 'c':
                System.out.println("及格");
                break;
            default:
                System.out.println("未知等级");
        }


    }
}
