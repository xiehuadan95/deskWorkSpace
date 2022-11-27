package com.xie.mybatis.controller;

import com.xie.mybatis.mapper.UserMapper;
import com.xie.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper mapper;
     @GetMapping("/queryAll")
    public List<User> queryAll(){
        List<User> userList = mapper.queryUserList();
         for (User user : userList) {
             System.out.println(user);
         }
        return userList;
    }
    //restful风格
    @GetMapping("/queryId/{id}")
    public User queryId(@PathVariable int id){
        User user1 = mapper.queryUserById(id);
            System.out.println(user1);
        return user1;
    }
    //@RequestBody 限定了前端传递的参数必须为json格式，
    //用POST方式进行提交,而且@RequestBody 只能有一个。
    //@RequestParam()可以有多个,用于接收url中的key-value参数的传递。
    // 通常我们用于get方式的请求
    @GetMapping("/queryId2")
    public User queryId2(@RequestParam("userId") int id){
        User user1 = mapper.queryUserById(id);
        System.out.println(user1);
        return user1;
    }


}
