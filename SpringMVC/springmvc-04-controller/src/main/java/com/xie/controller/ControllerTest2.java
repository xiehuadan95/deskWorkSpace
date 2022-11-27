package com.xie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/t2")
public class ControllerTest2 {

     @RequestMapping("t1")
    public String test2(Model model){
         model.addAttribute("msg","ControllerTest2");
        return "test";
    }
}
