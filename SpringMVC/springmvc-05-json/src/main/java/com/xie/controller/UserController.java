package com.xie.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.xie.pojo.User;
import com.xie.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

@Controller
public class UserController {
   // @RequestMapping(value = "/j1",produces = "application/json;charset=utf-8")
    @RequestMapping("/j1")
    //它不会走视图解析器，会直接返回一个字符串
    @ResponseBody
    public String json() throws JsonProcessingException {
        //jackson objectMapper对象生成字符串
        ObjectMapper mapper=new ObjectMapper();
        //创建对象
        User user = new User("tom",3,"女");
        String str = mapper.writeValueAsString(user);
        return str;
    }

    @RequestMapping("/j2")
    @ResponseBody
    public String json2() throws JsonProcessingException {
        //返回多个对象
        List<User> userList=new ArrayList<>();
        User user = new User("tom",3,"女");
        User user1 = new User("yom",23,"男");
        User user2 = new User("jom",32,"女");
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        return JsonUtils.getJson(userList);
    }

    @RequestMapping("/j3")
    @ResponseBody
    public String json3() throws JsonProcessingException {
        Date date =new Date();
        return JsonUtils.getJson(date,"yyyy-MM-dd HH:mm:ss");
    }
    @RequestMapping("/j4")
    @ResponseBody
    public String json4() throws JsonProcessingException {
        //返回多个对象
        List<User> userList=new ArrayList<>();
        User user = new User("tom",3,"女");
        User user1 = new User("yom",23,"男");
        User user2 = new User("jom",32,"女");
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        //java对象转换为json字符串
        String str = JSON.toJSONString(userList);
        System.out.println(str);
        String str1 = JSON.toJSONString(user1);
        System.out.println(str1);
        //json字符串转换为java对象
        User j_user1 = JSON.parseObject(str1, User.class);
        System.out.println(j_user1);
        //java对象转json对象
        JSONObject j_user2 = (JSONObject)JSON.toJSON(user2);
        System.out.println(j_user2);
        //json对象转java对象
        User to_java_user2 = JSON.toJavaObject(j_user2, User.class);
        System.out.println(to_java_user2);
        return "hello";

    }

}
