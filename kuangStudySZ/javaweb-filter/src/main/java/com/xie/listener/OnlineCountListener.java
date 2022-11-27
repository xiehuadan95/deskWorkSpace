package com.xie.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


//统计网站的在线人数 ： 统计session
public class OnlineCountListener implements HttpSessionListener {
    //创建session监听 监视你的举动
    //一旦创建一个session 就会触发一次这个事件
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext ctx=httpSessionEvent.getSession().getServletContext();
        Integer onlineCount=(Integer)ctx.getAttribute("OnlineCount");
        if(onlineCount==null){
            onlineCount=new Integer(1);
        }else{
            int count=onlineCount.intValue();
            onlineCount=new Integer(count+1);
        }
        ctx.setAttribute("OnlineCount", onlineCount);
    }
    //销毁session监听
    //一旦session 销毁就会出发
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext ctx=httpSessionEvent.getSession().getServletContext();
        Integer onlineCount=(Integer)ctx.getAttribute("OnlineCount");
        if(onlineCount==null){
            onlineCount=new Integer(0);
        }else{
            int count=onlineCount.intValue();
            onlineCount=new Integer(count-1);
        }
        ctx.setAttribute("OnlineCount", onlineCount);
    }
}
