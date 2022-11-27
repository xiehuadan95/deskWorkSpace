package com.xie.dao;

import com.xie.pojo.User;
import com.xie.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
       mapper.deleteUser(7);

      // mapper.addUser(new User(7,"hello","112233"));
        // int tom = mapper.updateUser(new User(7, "tom", "2135"));
       List<User> users = mapper.getUsers();
       for (User user : users) {
            System.out.println(user);
       }
      /*  User userByID = mapper.getUserByID(2);
        System.out.println(userByID);*/
        //关闭
        sqlSession.close();

    }
}
