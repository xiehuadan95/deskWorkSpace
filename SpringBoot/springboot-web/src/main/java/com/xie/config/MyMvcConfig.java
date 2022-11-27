package com.xie.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//如果我们要扩展springmvc 官方建议我们这样去做 不能加@EnableWebMvc
//@EnableWebMvc  导入了一个类 DelegatingWebMvcConfiguration：从容器中获取所有的webmvcconfig
//会导致mvc自动配置崩盘 ，因为Condition判定 已经存在，不满足自动配置的条件
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //扩展 视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //添加视图控制 这个路径可以直接跳转到test.html页面
       registry.addViewController("/xie").setViewName("test");
    }
}

