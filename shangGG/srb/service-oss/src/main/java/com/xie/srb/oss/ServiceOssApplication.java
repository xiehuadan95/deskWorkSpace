package com.xie.srb.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Author:Eric
 * DATE:2023/2/20-22:05
 * Decription: oss启动类
 */
@SpringBootApplication
@ComponentScan({"com.xie.srb","com.xie.common"})
public class ServiceOssApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceOssApplication.class,args);
    }
}
