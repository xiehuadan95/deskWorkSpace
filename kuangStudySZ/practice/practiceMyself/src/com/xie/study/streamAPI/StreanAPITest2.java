package com.xie.study.streamAPI;

import com.xie.study.pojo.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//stream的终止操作
public class StreanAPITest2 {
    //1.匹配与查找


    @Test
    public void test1() {
        List<Employee> list = EmployeeData.getEmployees();
        //allMatch(Predicate p)   检查是否匹配所有元素
        //是否所有员工的年龄都大于18岁
        boolean allMatch = list.stream().allMatch(employee -> employee.getAge() > 18);
        System.out.println(allMatch);
        //anyMatch(Predicate p)  检查是否至少匹配一个元素
        boolean anyMatch = list.stream().anyMatch(employee -> employee.getSalary() > 10000);
        System.out.println(anyMatch);
        //noneMatch(Predicate p)  检查是否没有匹配的元素,
        boolean noneMatch = list.stream().noneMatch(employee -> employee.getName().startsWith("马"));
        System.out.println(noneMatch);
        //findFirst()   返回第一个元素 Optional 是一个容器类
        Optional<Employee> first = list.stream().findFirst();
        System.out.println(first);
       //findAny()     返回当前流中的任意元素 stream()是顺序流 findAny会总从第一个取，
        // 如果用parallelStream()并行流就随机
        Optional<Employee> any = list.stream().findAny();
        System.out.println(any);

    }
    @Test
    public void test2(){
        List<Employee> list = EmployeeData.getEmployees();
        //count 返回流中元素的总个数
        long count = list.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);
        //max(Comparator c) 返回流中最大值
        //返回最高的工资
        Stream<Integer> salaryStream = list.stream().map(e -> e.getSalary());
        Optional<Integer> maxSalary = salaryStream.max(Integer::compare);
        System.out.println(maxSalary);
        //min(Comparator c) 返回流中最小值
        //返回最低工资的员工
        Optional<Employee> min = list.stream().min((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);
        //forEach(Consumer c) 内部迭代 遍历
        list.stream().forEach(System.out::println);
        //集合里面的遍历 操作 list.forEach(System.out::println);
        //使用Collection接口需要用户去做迭代 称为外部迭代

    }
    //归约 归成一个 自动累加
    @Test
    public void test3(){
        //reduce(T identity,BinaryOperator) 可以将流中元素反复结合起来，得到一个值，返回 T
        //计算1-10的自然数的和
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //初始值为0 ，也可以为其他数 会在流中的总数上加上此初始值为最终总数
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        //reduce(BinaryOperator) 可以将流中元素反复结合起来，得到一个值，返回Optional<T>
        //BinaryOperator是函数式接口，两个形参，返回一个值，3个值得类型一致<T,T,T> sum方法也是放两个参数 返回一个参数 类型一致
        //计算公司所有员工工资的总和
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Integer> salaryStream = employees.stream().map(Employee::getSalary);
        //Optional<Integer> salarySum = salaryStream.reduce(Integer::sum);
        Optional<Integer> salarySum = salaryStream.reduce((d1,d2)->d1+d2);
        System.out.println("员工总工资是："+salarySum);
    }
    //收集 得到多个数据 一个容器去重装一下
    @Test
    public void test4(){
        //collect(Collector c) 将流转换为其他形式，接收一个Collector接口的实现，用于给Stream中
        //元素做汇总的方法，Collector接口中方法的实现决定了如何对流执行收集的操作（如收集到List/Set/Map)
        //Collectors实用类提供了很多静态方法，调用就可以返回 Collector可以方便的创建常见收集器实例
        //查找工资大于6000的员工，结果返回为一个list 或Set还有 toCollection
        List<Employee> list = EmployeeData.getEmployees();
        List<Employee> employeeList = list.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toList());
        employeeList.forEach(System.out::println);
        System.out.println("================================");
        Set<Employee> employeeSet = list.stream().filter(e->e.getAge()>18).collect(Collectors.toSet());
        employeeSet.forEach(System.out::println);

    }

}
