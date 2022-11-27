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
    public void like(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> li = mapper.getUserLike("李");
        for (User user : li) {
            System.out.println(user);
        }
        //关闭资源
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
    public void getUserById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map map = new HashMap<String,Object>();
        map.put("helloid", 2);
        map.put("name2", "tom");
        User userById2 = mapper.getUserById2(map);
        System.out.println(userById2);
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
    //用map传
    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map map = new HashMap<String,Object>();
        map.put("userid",2);
        map.put("userName","tom");
        map.put("passWord","456789");

        int res  = mapper.addUser2(map);
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
