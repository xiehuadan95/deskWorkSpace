package com.xie.study.method;

public class Demo3 {
    public static void main(String[] args) {
       Demo3 demo3=new Demo3();
       demo3.method(1,2,3);

        }
       /**
        * 不定向参数，可变参数 一个方法只能有一个，必须在固定参数的后面
        * */
        public  void method(int x,int...i){
            System.out.println(i[0]);
            System.out.println(i[1]);

        }



    }

