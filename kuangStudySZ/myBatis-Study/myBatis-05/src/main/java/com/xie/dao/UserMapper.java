package com.xie.dao;

import com.xie.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface UserMapper {

    @Select("select * from user ")
    List<User> getUsers();
    //方法存在多个参数，所有的参数前面必须加 @Param 相当于别名的概念，由此注解来区分
    @Select("select * from user where id=#{id}")
    User getUserByID(@Param("id") int id2);
    //User getUserByID(@Param("id") int id,@Param("name") String name);

    @Insert("insert into user(id,name,pwd) values (#{id},#{name},#{password})")
    void addUser(User user);

    @Update("update  user set name=#{name},pwd=#{password} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from user where id=#{uid}")
    int deleteUser(@Param("uid")int id);

}
