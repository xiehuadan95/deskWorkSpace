package com.xie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContoller {
    @GetMapping("/tc")
    public String test(){
        System.out.println("TestController执行了····");
        return "ok";
    }
}
