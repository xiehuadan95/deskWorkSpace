package com.xie;

import com.xie.pojo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class OOMTest {
    public static List<Object> list =new ArrayList<>();
    //JVM 设置
    // -Xms5M -Xms5M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:\jvm.dump
    public static void main(String[] args) {
        List<Object> list1 = new ArrayList<>();
        int i=0;
        int j=0;
        while (true){
            list.add(new User(i++, UUID.randomUUID().toString()));
            list.add(new User(j--,UUID.randomUUID().toString()));
            list1.addAll(list);
        }
    }
}
