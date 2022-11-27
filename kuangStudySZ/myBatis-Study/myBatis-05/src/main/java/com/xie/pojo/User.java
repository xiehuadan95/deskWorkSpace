package com.xie.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//实体类 用注解取别名
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private  Integer id;
    private  String name;
    private  String password;



}
