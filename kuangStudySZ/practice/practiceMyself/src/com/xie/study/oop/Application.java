package com.xie.study.oop;

public class Application {
    public static void main(String[] args) {
        Object object = new Student();



        System.out.println(object instanceof Student);
        System.out.println(object instanceof Teacher);
        System.out.println(object instanceof Person);
        System.out.println(object instanceof Object);
        System.out.println(object instanceof String);
        System.out.println("========================");
        Person person=new Student();
        System.out.println(person instanceof Student);
        System.out.println(person instanceof Teacher);
        System.out.println(person instanceof Person);
        System.out.println(person instanceof Object);
        //System.out.println(person instanceof String);
        System.out.println("========================");
        Student student=new Student();
        System.out.println(student instanceof Student);
        //System.out.println(student instanceof Teacher);
        System.out.println(student instanceof Person);
        System.out.println(student instanceof Object);

        //类型之间的转化
        Person student2 = new Student();
        //转换为student 类型 以后才可以使用student的方法
        //高转低  向下强制转换
        Student st=(Student)student2;
        st.go();
        //低转高
        Student st2=new Student();
        st2.go();
        Person person1=st2;
        //丢失了子类自己的方法  父类引用指向子类对象


        //类：抽象的，实例化
       /* Student student = new Student();
        //student.name="jack";
        //System.out.println(student.name);
        student.setAge(15);
        int age =student.getAge();
        System.out.println(age);
        student.test("haha");
        student.test1();
        Person s=new Student();
        Student s2= new Student();
        s.print();
        s2.print();
        s2.run();*/


    }
}

