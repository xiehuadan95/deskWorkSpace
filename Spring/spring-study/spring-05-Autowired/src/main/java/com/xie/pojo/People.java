package com.xie.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;

import javax.annotation.Resource;

public class People {
    //如果显示的定义了Autowired的required属性为false，说明这个对象可以为Null,否则不允许为空
    @Resource(name="cat1")
    private Cat cat;
    @Resource(name="dog")
    private Dog dog;
    private String name;

    public People(@Nullable String name) {
        this.name=name;
    }

    public Cat getCat() {
        return cat;
    }
    public Dog getDog() {
        return dog;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "People{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }
}
