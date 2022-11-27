package com.xie.test;

import com.xie.service.IUserService;
import com.xie.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author:Eric
 * DATE:2022/11/13-9:37
 * Decription:
 */
public class SpringTest {
    @Test
    public void test() throws Exception {
//   通过xml加载上下文
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:/spring.xml");
        IUserService bean = ioc.getBean(IUserService.class); //用了aop 此时注入ioc容器的是 aop生成的代理类 这里代理类是不能用实现类来接收的，
//        UserServiceImpl bean = ioc.getBean(UserServiceImpl.class);
        System.out.println(bean.getClass());
        //在没有使用aop的情况下  class com.xie.service.impl.UserServiceImpl
       //当使用aop的情况下 class com.sun.proxy.$Proxy20 JDK代理所产生的动态代理类 生成在内存中的 必须用IUserService 接口才能接收 ，这个代理类也实现了这个接口
        //当被代理的类实现了接口会默认使用jdk代理
        //class com.xie.service.impl.UserServiceImpl$$EnhancerBySpringCGLIB$$34f6dd87 当被代理的类没有实现接口，用的cglib 代理所产生的代理类
        bean.select(1);
        System.out.println("===============");
    }
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:/spring.xml");
        System.out.println(ioc.getBean("user"));
        //获得bean本身
        System.out.println(ioc.getBean("&user"));

    }
}
