package atomic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Author:Eric
 * DATE:2023/1/11-21:00
 * Decription: AtomicReference作用是对普通对象的封装，它可以保证你在修改对象引用时的线程安全性
 */
public class AtomicStampedReferenceDemo {
    public static void main(String[] args) {
        User user1 = new User("张三", 23);
        User user2 = new User("李四", 25);
        User user3 = new User("王五", 20);
        //初始化为 user1
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(user1);
        //把 user2 赋给 atomicReference
        atomicReference.compareAndSet(user1, user2);
        System.out.println(atomicReference.get());
        //把 user3 赋给 atomicReference
        boolean b = atomicReference.compareAndSet(user1, user3);
        System.out.println(b);
        System.out.println(atomicReference.get());
        AtomicLong atomicLong = new AtomicLong(10);
        atomicLong.getAndAdd(10);
    }



}
 class User{
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

     @Override
     public String toString() {
         return "User{" +
                 "name='" + name + '\'' +
                 ", age=" + age +
                 '}';
     }
 }
