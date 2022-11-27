package com.xie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestFulController {
    //以前的http://localhost:8080/add?a=1&b=2
    //RestFul：http://localhost:8080/add/a/b

    //@RequestMapping(value = "/add/{a}/{b}",method = RequestMethod.GET)
    @GetMapping("/add/{a}/{b}")
    public String test1(@PathVariable int a,@PathVariable String b, Model model){
        String  res=a+b;
        model.addAttribute("msg","结果get为"+res);
        return "test";
    }
    @PostMapping("/add/{a}/{b}")
    public String test2(@PathVariable int a,@PathVariable String b, Model model){
        String  res=a+b;
        model.addAttribute("msg","结果post为"+res);
        return "test";
    }
}
