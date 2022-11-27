package com.tedu.practiceaop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name") String name,@RequestParam(value="age")Integer age){
        return "hello :"+name + "age="+age;
    }

}
