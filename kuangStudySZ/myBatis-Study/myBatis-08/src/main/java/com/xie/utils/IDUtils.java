package com.xie.utils;

import org.junit.Test;

import java.util.UUID;

//抑制警告
@SuppressWarnings("all")
public class IDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
    @Test
    public void test(){
        System.out.println(IDUtils.getUUID());
    }

}
