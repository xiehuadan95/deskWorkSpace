package com.xie.demo1;

//租客
public class Client {
    public static void main(String[] args) {
        //房东要出租房屋
        Host host = new Host();
        //代理 帮房东出租房屋 ，代理角色一般会有一些附属操作
        Proxy proxy = new Proxy(host);
        //直接面向代理租房
        proxy.rent();
    }
}
