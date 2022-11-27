package com.xie.study.staticProxy;


//静态代理模式总结：
/* 真实对象 和代理对象都要实现同一个接口
    代理对象 要代理真实角色
 */
//好处：代理对象可以做很多真实对象做不了的事情
//真实对象专注做自己的事情，
public class StaticProxy {
    public static void main(String[] args) {
        //真实对象 你要结婚
        You you=new You();
        //Thread 实现的Runnable接口
        new Thread(()-> System.out.println("我爱你")).start();

       new WeddingCompany(new You()).happyMarry();


        //把你 放入婚庆公司 调用
        WeddingCompany weddingCompany=new WeddingCompany(new You());
        weddingCompany.happyMarry();
    }
}
interface Marry{
    //结婚四大喜事
    void happyMarry();
}
//真实角色
class You implements Marry{
    @Override
    public void happyMarry(){
        System.out.println("要结婚了，超开心");
    }
}
//代理角色帮助你结婚
class WeddingCompany implements Marry{
    //代理谁？==真实目标角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        //真实对象
        this.target.happyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚之后收尾款");
    }

    private void before() {
        System.out.println("结婚之前布置现场");

    }
}