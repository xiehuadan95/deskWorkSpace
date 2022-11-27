package com.xie.study.annotation;


import java.lang.annotation.*;

//测试元注解
public class YuanZhuJie {
    //负责注解其他的注解，4个标准的meta-annotation类型
    //@Target()用于描述注解的使用范围 即被描述的注解可以用在什么地方
    // @Retention()表述需要在什么级别保存该注释信息，用于描述注解的声明周期 source<class<runtime
    // @Documented 说明该注解将被包含在javadoc中
    // @Inherited 说明子类可以继承父类中的该注解
    @MyAnnotation
    public void test(){

    }

}
//定义一个注解  可以放方法 类上，value可以传一个数组
//表示这个注解可以用在哪些地方
@Target(value= {ElementType.METHOD,ElementType.TYPE})
//表示注解在什么时候有效 源码、class、运行时候
@Retention(value = RetentionPolicy.RUNTIME)
//表示是否将我们的注解生成在javadoc中
@Documented
//Inherited表示子类可以继承父类的注解
@Inherited
//使用@interface自定义注解
@interface  MyAnnotation{

}