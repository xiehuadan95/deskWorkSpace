package com.xie.demo1;
//代理角色 实现方法
public class Proxy implements Rent{
    private Host host;
    public Proxy() {

    }
    public Proxy(Host host) {
        this.host = host;
    }
    @Override
    public void rent() {
        host.rent();
        seeHouse();
        hetong();
        fare();
    }
    //看房
    public void seeHouse(){
        System.out.println("中介可以带你看房");
    }
    //收中介费
    public void fare(){
        System.out.println("中介要收中介费");
    }
    //签合同
    public void hetong(){
        System.out.println("中介跟你签合同");
    }

}
