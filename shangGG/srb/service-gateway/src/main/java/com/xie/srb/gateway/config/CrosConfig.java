package com.xie.srb.gateway.config;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;

/**
 * Author:Eric
 * DATE:2023/2/26-16:21
 * Decription: gateway中添加的 跨域配置
 */
//@Configuration
public class CrosConfig {
    //跨域web过滤器 会检测远程前端服务器和后端是不是在一个服务器上
//    @Bean
    public CorsWebFilter corsFilter(){
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); //是否允许携带cookie  就允许cookie跨域了
        config.addAllowedOrigin("*"); //可接受的域 是一个具体域名或者 *  代表任意域名
       // config.addAllowedHeader("token"); 只运行携带token
        config.addAllowedHeader("*"); //允许携带的头
        config.addAllowedMethod("*"); //运行访问的方式 get post put ```
        //基于url的跨域配置策略
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",config);
        return new CorsWebFilter((CorsConfigurationSource) source);

    }











}
