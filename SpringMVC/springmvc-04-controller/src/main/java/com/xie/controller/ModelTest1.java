package com.xie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ModelTest1 {
    @RequestMapping("/m1/t1")
    public String test(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        return "test";
    }
    //无视图解析器配置
    @RequestMapping("/m1/t2")
    public String test1(Model model){
        model.addAttribute("msg","未配置视图解析器");
        //转发
        return "/WEB-INF/jsp/test.jsp";
    }

    @RequestMapping("/m1/t3")
    public String test3(Model model){
        model.addAttribute("msg","未配置视图解析器");
        //重定向
        return "redirect:/index.jsp";
    }
}
