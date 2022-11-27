package com.xie.config;

import com.xie.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//这个也会被Spring容器托管，注册到容器中，因为他本来就是一个@Component 代表这是一个配置类
//和之前的beans.xml一样
@Configuration
@ComponentScan("com.xie.pojo")
@Import(MyConfig2.class)//导入另外一个配置类 如同xml的import
public class MyConfig {
    //注册一个bean 就相当于我们之前写的一个bean标签
    //这个方法的名字相当于 id
    //这个方法的返回值相当于 class属性
    @Bean
    public User getUser(){
        //返回要注入到bean的对象
        return new User();
    }
}
