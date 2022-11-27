package com.xie.study.struct;

import java.util.Scanner;

public class IfDemo3 {
    public static void main(String[] args) {
        //考试分数
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入成绩：");
        int score = scanner.nextInt();
        /*
         * else必须放最后面 if多选择结构
         * */
        if (score == 100) {
            System.out.println("满分");
        } else if (score < 100 && score >= 90) {
            System.out.println("优秀");
        } else if (score < 90 && score >= 60) {
            System.out.println("良");
        } else if (score >= 0 && score < 60) {
            System.out.println("不及格");
        } else {
            System.out.println("输入的成绩不合法");
        }


        scanner.close();


    }
}
