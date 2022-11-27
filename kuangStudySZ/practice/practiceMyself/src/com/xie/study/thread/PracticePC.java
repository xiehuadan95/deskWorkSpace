package com.xie.study.thread;
//练习管程法
public class PracticePC {
    public static void main(String[] args) {

        Container container=new Container();
        new Productor2(container).start();
        new Consumer2(container).start();


    }
}

//产品
class Duck{
    int id;
    public Duck(int id){
        this.id=id;
    }
}

//生产者
 class Productor2 extends Thread{

   Container container;
   public Productor2(Container container){
       this.container=container;
   }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("生产了-->"+i+"只鸭");
            container.push(new Duck(i));

        }
    }
}

//消费者
class Consumer2 extends Thread{

    Container container;
    public Consumer2( Container container){
        this.container=container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("消费了-->"+container.pop().id+"只鸭");
        }
    }
}


//容器
class  Container{
  Duck [] ducks=new Duck[10];
  int count=0;
  public synchronized void push(Duck duck){
      if(count==ducks.length){
          try {
              this.wait();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
      ducks[count]=duck;
      count ++;
    this.notifyAll();
  }
public synchronized Duck pop(){
      //判断容器内有没有duck 如果没有停止消费
      if(count==0){
          try {
              this.wait();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
      count--;
      Duck duck=ducks[count];
    this.notifyAll();
      return duck;


}


}