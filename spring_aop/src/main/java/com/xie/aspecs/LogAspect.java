package com.xie.aspecs;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

/**
 * Author:Eric
 * DATE:2022/11/13-9:41
 * Decription: 以日志为例增强 业务逻辑类在容器中，所以切面也在容器中
 */
@Aspect    //标记为切面
@Component //标记为Bean组件，才能切入到ioc当中的bean
public class LogAspect {
    //声明切点的方式 让其他通知引用 重用性更强 后续可以直接调用pointcut方法 一样生效
    @Pointcut("execution(* com.xie.service.impl.*.*(..))")
    public void pointcut(){

    }

    //前置通知 切入所有的方法 所有参数 切点表达式 访问修饰符（可不写） * 代表所有类型的返回值，包名(..代表子孙包），*所有类名,*任何方法（*任何参数）
//    @Before("execution(public com.xie.entity.User com.xie.service.impl.*.*(..))")
//    @Before("execution(* com.xie.service.impl.UserServiceImpl.add(com.xie.entity.User))")
    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        //所有参数
        Object[] args = joinPoint.getArgs();

        System.out.println("前置通知~！"+methodName+"方法运行，参数是："+ Arrays.asList(args));
    }

    //后置通知 对入参是Integer的方法进行后置通知
    //@After("within(com.xie.service.impl.*)") within是粗粒度的只能匹配的类这一级别
    //@After("@annotation(jdk.nashorn.internal.runtime.logging.Logger))") 能匹配加有注解的方法，只要方法上加了指定注解的都可以 注解的完整限定名
    @After("execution(* com.xie.service.impl.*.*(Integer))")
    public void after(){
        System.out.println("后置通知~！");
    }
    //后置异常通知  可合并切点表达式 &&  ||  ！
//    @AfterThrowing("execution(* com.xie.service.impl.*.*(..)) && @annotation(jdk.nashorn.internal.runtime.logging.Logger))")
    @AfterThrowing(value="execution(* com.xie.service.impl.*.*(..))",throwing = "ex")
    public void afterThrowing(Exception ex){

        StringWriter sw = new StringWriter();
        //将异常栈信息打印 写入到StringWriter 固定写法
        ex.printStackTrace(new PrintWriter(sw,true));

        System.out.println("后置异常通知~！"+sw.getBuffer().toString());
    }
    //后置返回通知
    @AfterReturning(value="execution(* com.xie.service.impl.*.*(..))",returning = "returnValue")
    public void afterreturn(Object returnValue){
        System.out.println("输出返回值"+returnValue);
        System.out.println("后置返回通知~！");
    }
    //环绕通知
    @Around("pointcut()")
    public void arround(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        Object  returnValue="";
        try {
            System.out.println("环绕前置通知："+methodName+"方法执行，参数："+Arrays.asList(args));
            //环绕通知需要我们自己去执行
            returnValue = joinPoint.proceed();
            System.out.println("环绕后置返回通知："+methodName+"方法执行，参数："+Arrays.asList(args)+"返回值："+returnValue);
        } catch (Throwable throwable) {
            System.out.println("环绕异常通知"+throwable);
        }finally{
            System.out.println("环绕后置通知：");
        }
    }
}
