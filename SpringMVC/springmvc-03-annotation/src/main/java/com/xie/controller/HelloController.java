package com.xie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {
    //真实路径是 8080/hello/h1
    @RequestMapping("/h1")
    public String hello(Model model){
        //封装数据
        model.addAttribute("msg","hello,SpringmvcAnnotationl");
        //返回的 会被视图解析器处理
        return "hello";
    }
}
