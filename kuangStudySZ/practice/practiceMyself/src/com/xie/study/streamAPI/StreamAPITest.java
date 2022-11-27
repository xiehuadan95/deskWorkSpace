package com.xie.study.streamAPI;

import com.xie.study.pojo.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
* 1.Stream关注的是对数据的运算，与CPU打交道。集合关注的是数据的存储，与内存打交道
*2.Stream自己不会存储数据
Stream不会改变源对象，他们会返回一个持有结果的Stream
Stream操作延迟执行，会等到需要结果的时候才执行
* 3.Stream 执行流程
* Stream 实例化     一系列的中间操作（过滤、映射...）  终止操作
*
* 中间操作 ：一个中间**操作链**，可以对数据源的数据进行处理
终止操作：一旦执行终止操作，**就执行中间的操作链，并产生结果**。**之后不会再被使用**
* */
public class StreamAPITest {
    //创建 Stream的方式一： 通过集合 集合中有一个默认方法
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        //default Stream<E> stream():返回一个顺序流 拿数据会按照集合中的数据顺序来
        Stream<Employee> stream = employees.stream();
        //default Stream<E> parallelstream():返回一个并行流 同时取数据 数据不一定跟集合中的顺序一致
        Stream<Employee> parallelStream = employees.parallelStream();
    }

    //方式二：通过数组 数组的工具类的静态方法
    @Test
    public void test2() {
        int[] arr = new int[]{1, 5, 415, 5, 32};
        //调用Arrays类的静态方法 static<T> Stream<T> stream(T[] array): 返回一个流
        IntStream stream = Arrays.stream(arr);
        //可自定义数组
        Employee e1 = new Employee(1000, "JERRY", 30, 300);
        Employee e2 = new Employee(1001, "JSON", 25, 301);
        Employee[] arr1 = new Employee[]{e1, e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
    }
    //方式三  通过Stream的静态方法of()
    @Test
    public void test3() {
        Stream<Integer> integerStream = Stream.of(1, 5, 1, 5, 3, 5, 7);
    }

    //方式四： 创建无限流
    @Test
    public void test4() {
        //迭代  public static<T>Stream<T> iterate(final T seed,final UnaryOperator<T> f)
        //遍历前10个偶数 从0开始迭代 如果不加limit 会一直输出
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
        //生成 public static<T>Stream<T> generate(Supplier<T> s)
       // Stream.generate()方法里面需要放入 能出东西的内容 Supplier  可以一直出东西
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

}

class EmployeeData {
    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(100, "JACK", 18, 1500));
        list.add(new Employee(101, "rose", 19, 2500));
        list.add(new Employee(102, "tom", 18, 15000));
        list.add(new Employee(103, "lily", 20, 1800));
        list.add(new Employee(104, "lina", 21, 1890));
        list.add(new Employee(105, "lucy", 18, 18000));

        return list;
    }
}
