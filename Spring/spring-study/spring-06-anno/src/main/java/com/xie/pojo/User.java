package com.xie.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//等价于<bean id="user" class="com.xie.pojo.User"/>
//Component 组件
@Component
@Scope("singleton") //原型 prototype
public class User {
    //相当于<bean id="user" class="com.xie.pojo.User">
    // <property name="name" value="rose"/>
    @Value("rose")
    public String name;

}
