package com.xie.config;

import com.xie.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig2 {

    @Bean
    public User user(){
        return new User();
    }
}
