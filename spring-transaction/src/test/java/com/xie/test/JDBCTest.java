package com.xie.test;


import com.alibaba.druid.pool.DruidDataSource;
import com.xie.entity.User;
import com.xie.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:Eric
 * DATE:2022/11/15-21:53
 * Decription:
 */
public class JDBCTest {

  ClassPathXmlApplicationContext ioc;

  JdbcTemplate jdbcTemplate;

  @Before
  public void before(){
    ioc =new ClassPathXmlApplicationContext("classpath:spring.xml");
    jdbcTemplate = ioc.getBean(JdbcTemplate.class);
  }

  /**
   * 查询单个值
   */
  @Test
  public void test(){
    //查看数据源是否有问题能否拿到
    DruidDataSource bean = ioc.getBean(DruidDataSource.class);
    System.out.println(bean);
    Long res = jdbcTemplate.queryForObject("select count(*) from t_user", Long.class);
    System.out.println("查询得到的数量："+res);
  }

  /**
   * 查询实体
   */
  @Test
  public void test1(){
    //数据字段名和属性名一样  利用BeanPropertyRowMapper 映射，传入需要映射的实体类 User
    User user = jdbcTemplate.queryForObject("select * from t_user where id=1", new BeanPropertyRowMapper<>(User.class));
    System.out.println(user);
  }
  /**
   * 查询实体
   * 属性名跟字段名不一致 单个对象用queryForObject
   */
  @Test
  public void test2(){
//也可能返回的是List
    User user = jdbcTemplate.queryForObject("select * from t_user where id=1",
            //resultSet是jdbc的结果集 所需要的数据都在里面
            (resultSet, i) -> {
              User o =new User();
              //数据库的字段是 id 或者其他的
              o.setId(resultSet.getInt("id"));
              o.setRealname(resultSet.getString("realname"));
              return o;
    });
    System.out.println(user);
  }

  /**
   * 查询List<实体>
   */
  @Test
  public void test3(){

   List<User> user = jdbcTemplate.query("select * from t_user where id=1", new BeanPropertyRowMapper<>(User.class));
    System.out.println(user);
  }
  /**
   * 插入数据
   */
  @Test
  public void test4(){
    int res = jdbcTemplate.update("insert into t_user (realname,cardno,balance) values (?,?,?)", "李四", "123", "1101");
    System.out.println("插入成功条数："+res);
   List<User> user = jdbcTemplate.query("select * from t_user where realname='李四'", new BeanPropertyRowMapper<>(User.class));
    System.out.println("插入的数据为："+user);
  }
  /**
   * 更新数据
   */
  @Test
  public void test5(){
    int res = jdbcTemplate.update("update t_user set realname= ?,balance=? where id=? ", "王五", "2500", 6);
    System.out.println("更新功条数："+res);
    List<User> user = jdbcTemplate.query("select * from t_user where id=6", new BeanPropertyRowMapper<>(User.class));
    System.out.println("更新的数据为："+user);
  }
  /**
   * 删除
   */
  @Test
  public void test6(){
    int res = jdbcTemplate.update("delete from t_user  where id=? ", 7);
    System.out.println("删除功条数："+res);
    List<User> user = jdbcTemplate.query("select * from t_user where id>4", new BeanPropertyRowMapper<>(User.class));
    System.out.println("最后剩余数据："+user);
  }

  /**
   * 具名jdbctemplate 将具体的名字作为参数
   */
  @Test
  public void test7(){
    NamedParameterJdbcTemplate jdbcTemplateNamed = ioc.getBean(NamedParameterJdbcTemplate.class);
    Map<String,Object> map =new HashMap<>();
    map.put("id123",5);
    int res = jdbcTemplateNamed.update("delete from t_user  where id=:id123",map);
    System.out.println("删除的行数"+res);
    List<User> user = jdbcTemplate.query("select * from t_user", new BeanPropertyRowMapper<>(User.class));
    System.out.println("最后剩余数据："+user);

  }

  /**
   * 测试业务逻辑
   */
  @Test
  public void test8(){
    IUserService service = ioc.getBean(IUserService.class);
    User user = service.getUser();
    System.out.println(user);

  }

}
