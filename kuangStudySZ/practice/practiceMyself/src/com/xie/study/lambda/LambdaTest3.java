package com.xie.study.lambda;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;


/*
使用举例
 */
public class LambdaTest3 {
    @Test
    public void test() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("haha");
            }
        };
        r1.run();
        System.out.println("=======Lambda表达式===========");
        Runnable r2 = () -> System.out.println("我是Lambda表达式");
        r2.run();
    }

    @Test
    public void test2() {
        //比较两个对象的大小
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int com2 = com1.compare(121, 21);
        System.out.println(com2);

        System.out.println("=========Lambda表达式===========");
        Comparator<Integer> com = (a, b) -> Integer.compare(a, b);
        int compare = com.compare(11, 21);
        System.out.println(compare);

        System.out.println("=========Lambda表达式 优化 方法引用===========");
        //方法引用
        Comparator<Integer> com3 = Integer::compare;
        int compare3 = com3.compare(50, 21);
        System.out.println(compare3);
    }

    @Test
    public void test3() {
        Consumer<String> con1 = (s) -> System.out.println(s);
        con1.accept("hello world!");

        System.out.println("************************");

        Consumer<String> con2 = s -> System.out.println(s);
        con2.accept("hello world!");
    }

    //两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test4() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12,23));
        System.out.println("===============================");
        Comparator<Integer> com2 = (a, b) -> {
            System.out.println(a);
            System.out.println(b);
            return a.compareTo(b);
        };
        System.out.println(com1.compare(12,23));

    }


}
