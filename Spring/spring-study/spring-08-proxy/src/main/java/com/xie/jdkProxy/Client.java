package com.xie.jdkProxy;

public class Client {
    public static void main(String[] args) {
        //真实角色
        Host host=new Host();
        //代理角色 暂时没有
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        //通过调用程序处理角色 来处理我们要调用的接口对象！
        pih.setRent(host);
        //这里的proxy就是动态生成的，我们并没有写
        Rent proxy = (Rent) pih.getProxy();
        proxy.rent();

    }
}
