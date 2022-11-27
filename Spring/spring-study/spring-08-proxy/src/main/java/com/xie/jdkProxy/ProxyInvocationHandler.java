package com.xie.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//我们用这个类自动生成代理类 InvocationHandler 调用处理程序并返回结果
public class ProxyInvocationHandler implements InvocationHandler {
    //被代理的接口
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }
    //生成得到 代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                rent.getClass().getInterfaces(),  this);
    }
    //处理代理实例，并返回结果 调用代理类的一些执行方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       //执行接口上的方法
        //动态代理的本质，就是使用反射机制实现
        seeHouse();
        Object result = method.invoke(rent, args);
        fare();
        return result;
    }
    public void seeHouse(){
        System.out.println("中介带看房");
    }
    public void fare(){
        System.out.println("收中介费");
    }
}
