package com.xie.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //链式编程  授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问 功能页只有对应有权限的人才能访问 添加认证请求 ,所有的都能
        //请求授权的规则
        http.authorizeRequests().antMatchers("/").permitAll()
                //vip1 角色能访问
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
        //没有权限会默认到登录页面，需要开启登录的页面
        http.formLogin();

    }
   //认证，springboot 2.1.x可以直接使用
    //密码编码 PasswordEncoder
    //新增了很多的加密方法
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //这里从内存 正常聪哥数据库读
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("jack").password(new BCryptPasswordEncoder().encode("123456"))
                .roles("vip1","vip2").and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("root")).roles("vip3").and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");

    }

}
