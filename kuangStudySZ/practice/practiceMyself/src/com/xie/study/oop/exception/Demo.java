package com.xie.study.oop.exception;

public class Demo {
    public static void main(String[] args) {
        int a=1;
        int b=0;
        try{
            System.out.println(a/b);
            //想要补货的异常类型 可以是Throwable Error
        }catch (ArithmeticException e){
            System.out.println("程序出现异常，分母不能为0");
            //大的异常写后面 不然就不会执行后面的代码 捕获多个异常的时候 前面是小的
            //如果捕获了前面的异常，就不会执行后面的
        }catch(Throwable e){
            System.out.println("THROWABLE");
        }finally {
            System.out.println("finally");
        };
        //finally 可以不要，可以用于IO，scanner ，资源关闭

    }
    public void a(){b();};
    public void b(){a();};
}
