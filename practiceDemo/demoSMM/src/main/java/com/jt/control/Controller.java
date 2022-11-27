package com.jt.control;

import com.jt.pojo.User;
import com.jt.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class Controller {
    @Autowired
    private Service service;

    //接收post请求 前端传递的是JSON串
    //{“name":"","age":"","sex":""} 根据JSON数据key:value转化为对象（get/set方法)
    //参数加上注解 将json数据封装进user对象传递进去
    @PostMapping("/addUser")
    public String addUser(@RequestBody User user){
        service.addUser(user);
        return "新增成功";
    }
    @PostMapping("/addUserForm")
    //表单数据提交的时候已经用的params方式封装好成了一个对象提交过来
    public String addUserForm(User usr ){
        service.addUser(usr);
        return "新增成功";
    }
    @PostMapping("/user/{name}/{age}/{sex}")
    //前段以restful风格提交数据
    public String addUserRest(User usr ){
        service.addUser(usr);
        return "restful风格新增成功";
    }



    /**
     * 查询User表的全部数据
     * 请求路径: http://localhost:8088/getUser
     * 参数:     不需要参数
     * 返回值:  List<User>
     */
    @GetMapping("/getUser")
    public List<User> get(){
        List<User> userList = service.get();
        return userList;
    }
    @GetMapping("/getUserById")
    public User getUserById(Integer id){

        return service.getUserById(id);
    }
    @GetMapping("/user/{id}")
    //因为用的restful风格 如果参数是具体的参数需要加注解，如果参数是对象可以不加
    public User getUserById2(@PathVariable Integer id){
        return service.getUserById(id);
    }



}
