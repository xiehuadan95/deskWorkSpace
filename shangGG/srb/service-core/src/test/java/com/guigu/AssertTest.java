package com.guigu;


import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class AssertTest {

    @Test
    public void test1(){
        Object o =null;
        if(o == null){
            throw new IllegalArgumentException("参数不合法");
        }
    }
    @Test
    public void test(){
        Object o =null;
        //用断言替代if
       // Assert.assertNotNull("参数不合法",o);
        Assert.notNull(o,"参数不合法");
    }
    @Test
    public void test2(){

//        System.out.println(c);
        String str="a";
        StringBuffer append = new StringBuffer().append("c");
        String c1 =append+str;
        System.out.println(c1);
        System.out.println(append);
    }
}
