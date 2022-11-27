package com.xie.study.operator;
//导入这个包下所有的类
import com.xie.study.bass.Demo;


public class Demo1 {

    public static void main(String[] args) {
        int a=10;
        int b=20;
        long c=303154L;
        byte d=40;
        //值为0
        System.out.println(a/b);
        //值0.5
        System.out.println(a*1.0/b);

        //System.out.println((String)(a+d));
      Demo demo=new Demo();
        System.out.println(demo.name);
        demo.method(20);



    }
}
