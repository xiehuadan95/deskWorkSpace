package com.xie.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//标注这个类是一个SpringBoot的应用
@SpringBootApplication
public class HelloWorldApplication {
    public static void main(String[] args) {
        //将springboot应用类启动
        //springApplication类
        //
        SpringApplication.run(HelloWorldApplication.class, args);
    }
}
