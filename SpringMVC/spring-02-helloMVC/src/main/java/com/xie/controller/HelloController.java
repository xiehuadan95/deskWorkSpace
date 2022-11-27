package com.xie.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloController implements Controller {
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
      //ModelAndView 模型和视图
      ModelAndView mv=new ModelAndView();
      //封装对象，放在ModelAndView中
      mv.addObject("msg","HelloSpringMVC!");
      //封装要跳转的视图，放在ModelAndView中
      //根据配置的前缀后缀 拼装为 /WEB-INF/jsp/hello.jsp
      mv.setViewName("hello");
      return mv;

  }

}
