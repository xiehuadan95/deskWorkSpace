package com.xie.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//工具类，获取 sqlSessionFactory 工厂模式
public class MybatisUtils {
    //提升作用域
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            //获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //我们可以获得 SqlSession 的实例了，SqlSession 对象完全包含以数据库为背景的所有执行SQL操作的方法。
    // 以用 SqlSession 实例来直接执行已映射的SQL语句
    public static SqlSession getSqlSession(){
        //sqlSessionFactory调用open方法返回一个sqlsession
        return  sqlSessionFactory.openSession();
    }

}
