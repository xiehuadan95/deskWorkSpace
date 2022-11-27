package com.xie.study.annotation;

import java.lang.annotation.*;

//自定义注解
@MyAnnotation2
public class Test {
    //注解可以显示赋值，如果没有默认值，我们必须给注解赋值
    @MyAnnotation2(name="jack",age=18)
    public void test(){

    }
    @MyAnnotation3("rose")
    public void test2(){

    }

}
/**
 * @author EricXie
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    //注解的参数 参数类型一定要加（）不是方法  参数类型+参数名（）；
    String name() default "";
    int age() default  0;
    //如果默认值为-1 代表不存在 代表不存在
    int id() default -1;
    //数组value
    String [] schools() default {"清华","北大"};

}
/**
 * @author EricXie
 */
@Target({ElementType.METHOD  ,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnnotation3{
    //用value如果只有一个值，可以省略 仅value
    String value();

}
