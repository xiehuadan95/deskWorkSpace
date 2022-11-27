package com.xie.study.bass;

public class PremitiveType {
    //常量
    static final double PI=3.14;
    final static int NUMBER=100;
    //静态变量
    static String name="jack";
    //实例变量
    int age=18;

    public static void main(String[] args) {

        System.out.println(PremitiveType.name);
        System.out.println(PI);
        System.out.println(NUMBER);
        PremitiveType premitiveType=new PremitiveType();
        System.out.println(premitiveType.age);

        //整数拓展  进制 二进制 0b 十进制 八进制 o  十六进制 ox
        int num=10;
        int num1=0b10;
        int num2=010;
        int num3=0x11;
        System.out.println(num+"--二进制num1:"+num1+"八进制num2:"+num2+"十六进制num3:"+num3);
        System.out.println("============================================================");
        //浮点数拓展
        //需要用BigDecimal 数学工具类进行比较 不要用浮点数进行比较
        //=================================================
        float f=0.1f;
        double d=1.0/10;
        //flase
        System.out.println(f==d);

        float d1=54654654f;
        float d2=d1+1;
        //true 浮点数比较会有问题不准确
        System.out.println(d1==d2);
        System.out.println("============================================================");

        //字符拓展
        //所有的字符本质还是数字  编码Unicode 2字节 0-65536
        char c1='a';
        char c2='中';
        System.out.println(c1);
        //强制转换
        System.out.println((int)c1);
        System.out.println(c2);
        //强制转换
        System.out.println((int)c2);

        char c3='\u0061';
        System.out.println(c3);

        //转义字符
        //\t 制表符
        // \n 换行
        System.out.println("hello\tWorld");
        System.out.println("hello\nWorld");
        System.out.println("=======================================");

        //布尔值扩展
        boolean flag=true;
        if(flag){
            System.out.println("我是真的");
        }


    }
    static void method() {
        PremitiveType premitiveType=new PremitiveType();
        int age= premitiveType.age+20;
        System.out.println("将年龄加20"+age);
    }

}
