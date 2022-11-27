package com.xie.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//在templates目录下的所有页面，只能通过controller来跳转！
//这个需要模板引擎的支持！需要多导一个依赖
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
