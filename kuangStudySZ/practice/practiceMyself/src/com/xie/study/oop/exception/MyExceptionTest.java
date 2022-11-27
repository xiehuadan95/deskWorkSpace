package com.xie.study.oop.exception;

import com.sun.org.apache.xpath.internal.SourceTree;

public class MyExceptionTest {
    //可能存在异常的方法
    static void test(int a) throws MyException {
        if (a > 10) {
            throw new MyException(a);
        }
        System.out.println("OK");
    }

    public static void main(String[] args) {
        try {
            test(11);
        } catch (MyException e) {
            System.out.println("MyException-->"+e);
        }
    }
}
