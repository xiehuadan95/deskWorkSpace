package com.xie.security01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/tomain")
    public String tomain(){
        //重定向 依赖于我们的浏览器
        return  "redirect:/main.html";
    }
    @RequestMapping("/showLogin")
    public String showLogin(){
        return "login";
    }


}
