package com.xie.test;

import com.xie.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Author:Eric
 * DATE:2022/11/16-22:18
 * Decription:
 */
public class TransactionTest {
    ClassPathXmlApplicationContext ioc;

    JdbcTemplate jdbcTemplate;

    @Before
    public void before(){
        ioc =new ClassPathXmlApplicationContext("classpath:spring.xml");
        jdbcTemplate = ioc.getBean(JdbcTemplate.class);
    }

    @Test
    public void test(){
        IUserService service = ioc.getBean(IUserService.class);
        service.trans();

    }
}
