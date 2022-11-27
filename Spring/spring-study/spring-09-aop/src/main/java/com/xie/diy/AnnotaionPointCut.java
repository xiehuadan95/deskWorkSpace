package com.xie.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//方式三：使用注解方式实现AOP
//注解标注此类为一个切面
@Aspect
public class AnnotaionPointCut {
    //切入点 内容 找到这个类的所有方法，所有参数
    @Before("execution(* com.xie.service.UserServiceImpl.* (..))")
    public void before(){
        System.out.println("方法执行前~");
    }

    @After("execution(* com.xie.service.UserServiceImpl.* (..))")
    public void after(){
        System.out.println("方法执行后~~");
    }
    //在环绕增强中，我们可以给定一个参数，代表我们要获取处理切入的点
    @Around("execution(* com.xie.service.UserServiceImpl.* (..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前~");
        //获得签名
        Signature signature = jp.getSignature();
        System.out.println("signature:"+signature);
        //执行方法
        Object proceed = jp.proceed();
        System.out.println("环绕后~");
    }
}
