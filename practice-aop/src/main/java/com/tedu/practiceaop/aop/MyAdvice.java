package com.tedu.practiceaop.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class MyAdvice {

    private Logger logger=LoggerFactory.getLogger(MyAdvice.class);
                           // 不论什么修饰符+ 路径 +包名+任意类+任意方法+参数个数和类型 不限
    @Pointcut(value = "execution(* com.tedu.practiceaop.controller.*.*(..))")
    public void myPointcut(){

    }
    @Around(value = "myPointcut()")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        String className = pjp.getTarget().getClass().toString();
        String methodName = pjp.getSignature().getName();
        Object[] arry = pjp.getArgs();

        ObjectMapper mapper = new ObjectMapper();

        logger.info("方法执行前的类名"+className+"方法名："+methodName+"参数："+mapper.writeValueAsString(arry));
        Object obj = pjp.proceed();
        logger.info("方法执行后的类名："+className+"方法名"+methodName+"返回值"+mapper.writeValueAsString(obj));

        return  obj;

    }

}
