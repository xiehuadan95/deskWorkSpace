package com.xie.study.syn;
//不安全的取钱
//两个人去银行取钱
public class UnsafeBank {
    public static void main(String[] args) {
        //账户
        Account account=new Account(100,"结婚基金");

        Drawing you=new Drawing(account,50,"你");
        Drawing girlfriend=new Drawing(account,100,"girlfriend");

        you.start();
        girlfriend.start();

    }

}

//账户
class Account{
    //余额
    int money;
    //卡名
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}
//银行 模拟取款
class Drawing extends Thread{
    //账户
    Account account;
    //取了多少钱
    int  drawingMoney;
    //现在手里有多少钱
    int nowMoney;
    public Drawing(Account account,int drawingMoney,String name){
        //调用父类 Thread的有参构造 可以传String
        super(name);
        this.account=account;
        this.drawingMoney=drawingMoney;

    }
    //取钱  sychronized 默认锁的是this  加在这里对you 和girlfriend 没有用，锁的事Drawing
    @Override
    public synchronized void run(){
        //锁的是账户对象 锁的对象就是变化的量，需要增删改的对象
        synchronized (account){
            //判断有没有钱
            if(account.money-drawingMoney<0){
                System.out.println(Thread.currentThread().getName()+"钱不够，取不了！");
                return;
            }
            //模拟延时 sleep放大代码的真实性
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额=余额-取的钱
            account.money=account.money-drawingMoney;
            //你手里的钱
            nowMoney=nowMoney+drawingMoney;
            System.out.println(account.name+"余额为："+account.money);
            //Thread.currentThread().getName() = this.getName()
            System.out.println(this.getName()+"手里的钱："+nowMoney);
        }

    }
}