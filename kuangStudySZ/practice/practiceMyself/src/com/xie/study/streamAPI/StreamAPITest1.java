package com.xie.study.streamAPI;
//中间操作

import com.xie.study.pojo.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.stream.Stream;

public class StreamAPITest1 {
    //1.筛选与切片
    @Test
    public void test1() {
        List<Employee>  list = EmployeeData.getEmployees();
//filter(Predicate p) 接收Lambda,从流中排除某些元素
        Stream<Employee> stream = list.stream();
        //老写法
       /* stream.filter(new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                boolean flag = employee.getSalary() > 2000 ? true : false;
                return flag;
            }
        }).forEach(System.out::println);*/
        //新写法 查询员工表中薪资大于2000的
        stream.filter(e -> e.getSalary() > 2000).forEach(System.out::println);
        System.out.println("======================");
        //limit(long maxSize)截断流，使其元素不超过给定数量
        list.stream().limit(4).forEach(System.out::println);
        System.out.println("======================");
        //skip(long n)跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回一个空流，与limit(n)互补
        list.stream().skip(2).forEach(System.out::println);
        System.out.println("======================");
        //distinct()  筛选，通过流所生产元素的hashCode()和equals()去除重复元素  这里需要重写实体类的 hashCode方法 和equals
        list.add(new Employee(1000,"小动物",40,2000));
        list.add(new Employee(1000,"小动物",41,2000));
        list.add(new Employee(1000,"小动物",40,2000));
        list.add(new Employee(1000,"小动物",40,2000));

        list.stream().distinct().forEach(System.out::println);

    }
    //映射
    @Test
    public void test2(){
        //map(Function f)  接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被映射到每个元素上，并将其映射成一个新的元素
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd","EE");
        list.stream().map(str->str.toUpperCase()).forEach(System.out::println);
        //练习 获取员工姓名长度大于3的员工的姓名
        List<Employee> list1 = EmployeeData.getEmployees();
        Stream<String> stringStream = list1.stream().map(Employee::getName);
        stringStream.filter(name->name.length()>3).forEach(System.out::println);
       // list1.stream().map(employee -> employee.getName().length()>3).forEach(System.out::println); 这种方式返回的是blooean
        System.out.println();
        //flatMap(Function f)  接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        // 老方式
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStrToStream);
        streamStream.forEach(s->{
            s.forEach(System.out::println);
        });
        System.out.println();
        //用flatMap
        list.stream().flatMap(StreamAPITest1::fromStrToStream).forEach(System.out::println);

    }
    //将字符串中的多个字符构成的集合 转换为对应的Stream的实例
    public static Stream<Character> fromStrToStream(String str){
        ArrayList<Character> list =new ArrayList<>();
        for (Character c:str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }
    @Test
    public void test3(){
        ArrayList list1=new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList list2=new ArrayList();
        list2.add(4);
        list2.add(5);
        list2.add(6);
       // list1.add(list2);
        list1.addAll(list2);
        System.out.println(list1);
    }
    @Test
    public void test4(){
        //sorted()  产生一个新流，其中按自然顺序排序
        List<Integer> list = Arrays.asList(15, 58, 100, -45, 0, 34, 7, 9);
        list.stream().sorted().forEach(System.out::print);
        System.out.println();

       /*
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted().forEach(System.out::print);
        */
        //sorted(Comparator com) 产生一个新流，其中按比较器顺序排序【定制化排序】
        //涉及对象的排序 需要实现Comparable接口
        List<Employee> employees = EmployeeData.getEmployees();
        //lambda可简化为：(（e1,e2）->Integer.compare(e1.getAge(),e2.getAge())
        employees.stream().sorted((e1,e2)->{
            return Integer.compare(e1.getAge(),e2.getAge());
        }).forEach(System.out::println);
        //根据年龄判断，如果年龄相等再根据salary从大到小判断
        employees.stream().sorted((e1,e2)->{
            int ageValue=Integer.compare(e1.getAge(),e2.getAge());
            if (ageValue!=0){
                return ageValue;
            }else{
                return -Double.compare(e1.getSalary(), e2.getSalary());
            }
        }).forEach(System.out::println);


    }

}
