package com.xie.filter;

import javax.servlet.*;
import java.io.IOException;

//编码过滤器
public class CharacterEncodingFilter implements Filter {
    //初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
    }
  //chain :链
    /*
    * 1.过滤器中的所有代码，在过滤特定请求的时候都会执行
    * 2.必须要让过滤器继续通行转交到后面
    * */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=UTF-8");
        System.out.println("characterEncodingFilter执行前...");
        //让我们的请求继续走，如果不写，程序到这就停止了
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("characterEncodingFilter执行后...");
    }
    //销毁  web服务关闭的时候会销毁
    @Override
    public void destroy() {

    }
}
