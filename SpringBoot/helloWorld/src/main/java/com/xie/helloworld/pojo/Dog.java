package com.xie.helloworld.pojo;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "dog")
public class Dog {
    //@Value("旺财")
    private String firstName;
    //@Value("3")
    private Integer age;


}
