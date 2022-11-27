package com.xie.mybatis.mapper;

import com.xie.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//表示这是一个mybatis的mapper类
@Mapper
//被spring管理 也可以@Component
@Repository
public interface UserMapper {
    //可以加
    //public  static final int age=18;

    List<User> queryUserList();

    User queryUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
