package com.xie.study.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

//反射操作注解
public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.xie.study.reflection.Student2");
        //通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        //获得 注解的value的值
        TableXie annotation = (TableXie) c1.getAnnotation(TableXie.class);
        String value = annotation.value();
        System.out.println(value);


        //获得类指定的注解
        Field f = c1.getDeclaredField("name");
        FieldXie annotation1 = f.getAnnotation(FieldXie.class);
        System.out.println(annotation1);
        System.out.println(annotation1.columnName());
        System.out.println(annotation1.type());
        System.out.println(annotation1.length());

    }

}
//映射到表名 字段
@TableXie("db_student")
class Student2{
    @FieldXie(columnName = "db_id",type = "int",length = 10)
    private int id;
    @FieldXie(columnName = "db_age",type = "int",length = 10)
    private int age;
    @FieldXie(columnName = "db_name",type = "varchar",length = 3)
    private  String name;

    public Student2() {
    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface  TableXie{
    String value();
}

//属性的注解 对应的一张表
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldXie{
    String columnName();
    String type();
    int length();
}