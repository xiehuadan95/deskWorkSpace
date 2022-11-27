package com.jt;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestMP2 {
    @Autowired
    private UserMapper userMapper;
    /*
    将ID=231的用户名称 改为六一儿童节
    * */
    @Test
    public void get(){
        User user=new User();
        user.setName("六一儿童节").setId(231);
        userMapper.updateById(user);
        System.out.println("数据更新成功");

    }
    /**
     * 更新操作2
     *      将name="六一儿童节" 改为"端午节"
     *  参数说明:
     *         1.实体对象  封装修改后的数据 set结构
     *         2.UpdateWrapper 修改的条件构造器
     *  Sql: update demo_user set name="端午节" where name="61"
     */
    @Test
    public void get2(){
        User user = new User();
        user.setName("儿童节");
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("name","六一儿童节");
        userMapper.update(user,userUpdateWrapper);
        System.out.println("数据更新成功！");
    }





}
