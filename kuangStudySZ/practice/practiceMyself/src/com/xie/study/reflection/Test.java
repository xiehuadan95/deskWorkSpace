package com.xie.study.reflection;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.xml.bind.SchemaOutputResolver;

//Class类的创建方式有哪些
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person =new Student();
        System.out.println("这个人是："+person.name);

        //方式一：通过对象获得 这个Class类
        Class c1 = person.getClass();
        System.out.println("hashcode:"+c1.hashCode());

        //方式二：forName获得
        Class c2 = Class.forName("com.xie.study.reflection.Student");
        System.out.println("hashcode:"+c2.hashCode());

        Class aClass = Class.forName("com.xie.study.reflection.Teacher");
        System.out.println(aClass);


        //方式三：通过类名获得
        Class c3 = Student.class;
        System.out.println("hashcode:"+c3.hashCode());

        Class teacherClass = Teacher.class;
        System.out.println(teacherClass);

        //方式四：基本内置类型的包装类都有一个Type属性
        Class c4 = Integer.TYPE;
        System.out.println(c4);

        Class type = Character.TYPE;
        System.out.println(type);

        System.out.println("========获得父类类型========");
        //获得父类类型
        Class C1 = c1.getSuperclass();
        System.out.println(C1);

        Class C2 = c2.getSuperclass();
        System.out.println(C2);

        Class superclass = c4.getSuperclass();
        System.out.println(superclass);

        Class superclass1 = type.getSuperclass();
        System.out.println(superclass1);


    }

}
class Student extends Person{
    public Student(){
        this.name="学生";
    }
}
class Teacher extends Person{
    public Teacher(){
        this.name="谢老师";
    }
}

class Person{
    public String name;
    public int age ;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
