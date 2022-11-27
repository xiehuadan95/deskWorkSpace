package com.xie.study.pojo;

public class Employee {
    private  int id;
    private  String name;
    private  int age;

    @Override
    public int hashCode() {
        int result;
        long temp;
        result =id;
        result =31*result+(name!=null ? name.hashCode() : 0);
        result =31*result +age;
        temp =Double.doubleToLongBits(salary);
        result = 31 *result +(int)(temp ^ (temp>>>32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee() {
    }

    private int salary;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public Employee(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
