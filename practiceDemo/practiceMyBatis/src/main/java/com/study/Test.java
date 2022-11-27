package com.study;

import com.study.pojo.Dept;
import com.study.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        //加载核心配置文件
       /* InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //创建会话工厂
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        //创建会话
        SqlSession sqlSession=factory.openSession();
        //执行sql语句
        List<User> list =sqlSession.selectList("m1.get");
        //处理返回值
        for (User user : list) {
            System.out.println(user);
        }*/
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        //创建会话
        SqlSession session =factory.openSession();
        //执行sql
        List<User> list = session.selectList("m1.get");
        List<Dept> list1 = session.selectList("d1.sel");

        for (User user : list) {
            System.out.println(user);
        }
        for (Dept dept : list1) {
            System.out.println(dept);
        }

    }

}
