package com.xie.study.syn;
//不安全的买票
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station,"jack").start();
        new Thread(station,"rose").start();
        new Thread(station,"lily").start();

    }
}
class BuyTicket implements Runnable{
    //票
    private int ticketNums=10;
    //外部停止方式
    private boolean flag=true;
    @Override
    public void run() {
        //买票
        while(flag){
            buy();
        }
    }
    //加了同步锁 就成了同步方法保证方法的安全 锁的是 this
    private  synchronized void buy(){
        //判断是否有票
        if(ticketNums<=0){
            flag=false;
            return;
        }
        //模拟延时
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //买票
        System.out.println(Thread.currentThread().getName()+"拿到了"+ticketNums--);
    }

}