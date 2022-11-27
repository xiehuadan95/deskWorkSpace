package com.xie.study.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

//内置的4大核心函数式接口
//消费型 Consumer<T>  void accept(T t)
//供给型 Supplier<T>  T get()
//函数型接口 Function<T,R> R apply(T t)
//断言型接口 Predicate<T> boolean test(T t)
public class LambdaTest2 {
    //消费型接口
    @Test
    public void test1(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("我要去休息，花费："+aDouble);
            }
        });
        System.out.println("*************************");
        happyTime(300, money->System.out.println("我要去休息，花费："+money));
    }
    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }
    //断言型接口
    @Test
    public void test2(){
        List<String> list= Arrays.asList("jack","rose","南京","北京","普京");
        List<String> filterStr = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterStr);
        System.out.println("*************Lambda***************");
        List<String> filterStr1=filterString(list,s->s.contains("京"));
        System.out.println(filterStr);
    }
    //根据给定的规则，过滤集合中的字符串，此规则由Predicate的方法决定 断言成功 执行
    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList=new ArrayList<>();
        for(String s:list){
            //断言返回的是boolean值
            if(pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;


        }
    }


