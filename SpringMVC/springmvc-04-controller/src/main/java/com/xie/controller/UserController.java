package com.xie.controller;

import com.xie.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model){
        //接收前端参数
        System.out.println("接收到的参数为："+name);
        //2.将返回的结果传递给前端
        model.addAttribute("msg",name);
        //跳转视图
        return "test";
    }
    //接收的是一个对象
    @GetMapping("/t2")
    public String test2(User user){
        //接收前端参数
        System.out.println("接收到的参数为："+user);
        //2.将返回的结果传递给前端
        //model.addAttribute("msg",user);
        //3.跳转视图
        return "test";
    }

    //restFull风格
    @GetMapping("/t3/{name}")
    public String test3(@PathVariable String name, Model model){
        //接收前端参数
        System.out.println("接收到的参数为："+name);
        //2.将返回的结果传递给前端
        model.addAttribute("msg",name);
        //3.跳转视图
        return "test";
    }
    //ModelMap回显
    @GetMapping("/t4")
    public String test4(ModelMap model){
        //接收前端参数
        //2.将返回的结果传递给前端
        model.addAttribute("msg","sdfd");
        //3.跳转视图
        return "test";
    }
}
