package com.cy.jt.system.web.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class PageUtils {

     public static <T>Page<T> startPage(){
         //spring中获取request对象
         ServletRequestAttributes requestAttributes=
         (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
         HttpServletRequest request=requestAttributes.getRequest();
         //基于请求对象获取请求中的参数(....)
         String pageCurrentStr=request.getParameter("pageCurrent");
         String pageSizeStr=request.getParameter("pageSize");
         if(pageCurrentStr==null||"".equals(pageCurrentStr))
               pageCurrentStr="1";
         if(pageSizeStr==null||"".equals(pageSizeStr))
               pageSizeStr="3";
         Integer pageCurrent=Integer.parseInt(pageCurrentStr);
         Integer pageSize=Integer.parseInt(pageSizeStr);

         return PageHelper.startPage(pageCurrent,pageSize);
     }
}
