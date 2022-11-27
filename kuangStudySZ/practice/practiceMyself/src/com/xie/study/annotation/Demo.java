package com.xie.study.annotation;


import java.util.ArrayList;
import java.util.List;

public class Demo extends Object {

    @Override
    public String toString(){
        return super.toString();
    }
    //注解的意思：不推荐程序员使用，但是可以使用，或存在更好的方式
    @Deprecated
    public static void test(){
        System.out.println("Deprecated");
    }
    //镇压警告 要放入参数 平时一般不用 只有一个值可以省略value
    @SuppressWarnings("all")
    public void test02(){
        List list=new ArrayList();
    }
    public static void main(String[] args) {
        test();
    }

}
