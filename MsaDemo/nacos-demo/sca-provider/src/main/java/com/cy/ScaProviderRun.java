package com.cy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients
@SpringBootApplication
public class ScaProviderRun {
    public static void main(String[] args) {
        SpringApplication.run(ScaProviderRun.class, args);
    }
    @Value("${server.port}")
    private String server;

    @RestController
    public class ProviderController{
        @GetMapping("/provider/echo/{str}")
        public String doEcho(@PathVariable  String str){

            return server+"::say Hello::"+str;
        }
    }
}
