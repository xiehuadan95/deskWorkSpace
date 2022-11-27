package com.xie.study.optional;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {
//创建Optional类对象的方法：
//Optional.of(T t) :创建一个Optional 实例，t 必须非空；
//Optional.empty() : 创建一个空的Optional 实例
//Optional.ofNullable(T t) : t可以为null
    @Test
    public void test1(){
        Girl girl = new Girl();
        //girl=null  必须保证t 非空
        Optional<Girl> optionalGirl = Optional.of(girl);
    }
    @Test
    public void test2(){
        Girl girl = new Girl();
        girl=null;  //t可以为空
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);
        //如果当前容器内部的t 为空 则返回 我指定的orElse方法里的参数t1.
        //如果内部非空，则返回内部的
        Girl girl1 = optionalGirl.orElse(new Girl("rose"));
        System.out.println(girl1);


    }
    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }
    @Test
    public void test3(){
        Boy boy=new Boy();
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    //第一次优化以后的getGirlName方法
    public String getGirlName1(Boy boy){
        if(boy !=null){
            Girl girl=boy.getGirl();
            if(girl!=null){
                return girl.getName();
            }
        }
        return null;
    }
    @Test
    public void test4(){
        Boy boy=new Boy();
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }
    //使用Optional类的getGirlName()
    public String getGirlName2(Boy boy){
        //boy可能为null
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        //此时boy一定非空
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("lily")));
        Girl girl = boy1.getGirl();
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        //girl1一定非空了
        Girl girl1 = girlOptional.orElse(new Girl("迪丽热巴"));

        return girl1.getName();
    }
    @Test
    public void test5(){
       // Boy boy=null;
        Boy boy=new Boy();
        String girlName = getGirlName2(boy);
        System.out.println(girlName);
    }
}
