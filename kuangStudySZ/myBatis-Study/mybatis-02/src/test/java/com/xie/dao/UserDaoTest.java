package com.xie.dao;

import com.xie.pojo.User;
import com.xie.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    @Test
    public void test(){
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //getMapper ()执行sql 获取dao的接口对象 要拿到sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //得到返回对象，执行里面的方法
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(2);
        System.out.println(userById);
        //关闭资源
        sqlSession.close();
    }
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.addUser(new User(5, "李四", "888888"));
        if(res>0){
            System.out.println("插入成功");
        }
        //提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.updateUser(new User(4, "法外狂徒", "666666"));
        if(res>0){
            System.out.println("更新成功");
        }
        //提交事务
      sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }
    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.deleteUser(2);
        if (res > 0) {
            System.out.println("删除成功");
        }
        //提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }

}
