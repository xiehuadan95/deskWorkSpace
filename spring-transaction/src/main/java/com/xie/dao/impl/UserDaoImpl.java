package com.xie.dao.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.xie.dao.IUserDao;
import com.xie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Author:Eric
 * DATE:2022/11/15-21:40
 * Decription:
 */
@Repository
public class UserDaoImpl implements IUserDao {
    //jdbcTemplate是线程安全的 底层用的localThread来保证
   private JdbcTemplate jdbcTemplate;
   //自动注入数据源 这样用更好一点 也可以直接 jdbcTemplate @Autowired
   @Autowired
    public void setDataSource(DruidDataSource dataSource){
       this.jdbcTemplate=new JdbcTemplate(dataSource);
   }
   @Override
   public User getUser(){
       return jdbcTemplate.queryForObject("select * from t_user where id=1",new BeanPropertyRowMapper<>(User.class));
   }

    @Override
    public void sub() {
        jdbcTemplate.update("update t_user set balance=balance-200 where id=1");
        User user = jdbcTemplate.queryForObject("select * from t_user where id=1", new BeanPropertyRowMapper<>(User.class));
        System.out.println("lilei目前的详细信息为："+user);
    }

    @Override
    public void save() {
       jdbcTemplate.update("update t_user set balance=balance+200 where id=2");
        User user = jdbcTemplate.queryForObject("select * from t_user where id=2", new BeanPropertyRowMapper<>(User.class));
        System.out.println("lily目前的详细信息为："+user);
    }

}
