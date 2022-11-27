package com.xie.security01.config;

import com.xie.security01.hander.MyAuthenticationFailHandler;
import com.xie.security01.hander.MyAuthenticationSucessHandler;
import com.xie.security01.service.impl.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

//@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userServiceImpl;
    @Autowired
    public DataSource dataSource;


//   指定加密的方式
    @Bean
    public PasswordEncoder passwordEncoder(){
        //指定不进行加密
//        return NoOpPasswordEncoder.getInstance();
        //推荐加密方式
        return  new BCryptPasswordEncoder();
    }

    //需要配认证管理器相关的方法
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //可实现自定义的userDetailsService的实现类
        auth.userDetailsService(userServiceImpl);
//        super.configure(auth);
        //基于配置方式设置密码 设定权限 内存
       /* auth.inMemoryAuthentication()
                .withUser("xiexie")
                .password(passwordEncoder().encode("123"))
                .authorities("admin");*/
        System.out.println("默认的权限设定方式！指定自己的userDetailsService");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //认证
        //自定义的表单登录 要求必须是post请求 默认要 usernam  password也可以自定义表单参数
        http.formLogin()
//                .usernameParameter("name")
        .loginPage("/login.html")   //指定登录页面
        .loginProcessingUrl("/user/login")
//                登录成功之后 跳转
                .defaultSuccessUrl("/main.html");
//                也可以成功后跳转到这个页面 转发 依赖与我们的服务器
//                .successForwardUrl("/tomain");
                //自定义认证成功后的处理
//                .successHandler(new MyAuthenticationSucessHandler("/main.html"))
//                .failureHandler(new MyAuthenticationFailHandler("/error.html"));
                //失败转发到这个接口
//                .failureForwardUrl("/toerror");
        //自定义退出登录界面
     /*   http.logout()
                .logoutUrl("/Logout")
                .logoutSuccessUrl("/Login.html");*/
        //session失效管理
        http.sessionManagement()
                //会话失效跳转到哪个路径
               // .invalidSessionUrl("/session/invalid")
                //只允许一个会话存在 并发控制，
                .maximumSessions(1)
                //如果是true阻止挤兑登录 之前登录的人员不会被挤下线 但是也可能自己会话超时了也登录不上 一般都自己实现并发控制 session存redis里面自己判断
                .maxSessionsPreventsLogin(false);
        //授权
        http.authorizeRequests()
                //这些不需要认证 也可以访问
                .antMatchers("/login.html","/user/login","/error.html","/session/invalid").permitAll()
                //任何请求都要认证 就无法访问到 login.html
                .anyRequest().authenticated();
                //csrf保护 跨站点请求伪造攻击 这里关闭了 可以用模板引擎去做
//                http.csrf().disable();

        //记住我
        http.rememberMe()
                .tokenRepository(persistentTokenRepository())//设置持久化仓库 用的mysql 需要数据源的配置
                .tokenValiditySeconds(3600) //超时时间,单位s 默认两周
                .userDetailsService(userServiceImpl); //设置自定义登录逻辑
    }
    public PersistentTokenRepository persistentTokenRepository(){
        //持久token的仓库
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        //设置数据源
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }
}
