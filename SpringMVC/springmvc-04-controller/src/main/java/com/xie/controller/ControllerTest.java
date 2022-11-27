package com.xie.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//只要实现Controller的类 说明这就是一个控制器
@Controller
public class ControllerTest {
    @RequestMapping("/t2")
    public String test1(Model model) {
       model.addAttribute("msg", "ControllerTest");
        return "test";
    }

}
