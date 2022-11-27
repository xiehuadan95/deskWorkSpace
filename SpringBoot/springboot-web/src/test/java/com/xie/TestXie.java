package com.xie;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class TestXie {

    @Test
    public void test1(){
        Set<String> set = new HashSet<>();
        set.add("abc");
        set.add("bcd");
        set.add("bcd");
        System.out.println(set);


    }


}
