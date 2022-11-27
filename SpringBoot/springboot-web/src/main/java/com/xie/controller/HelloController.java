package com.xie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
public class HelloController {
    @GetMapping("/test")
    public String hello(Model model){
        model.addAttribute("msg","<h2>helloThymeleaf</h2>");
        //测试模板遍历，在集合中放两个元素
        model.addAttribute("users", Arrays.asList("jack","tom"));
        return "test";
    }
}
