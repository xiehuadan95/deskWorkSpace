package com.xie.service.impl;

import com.xie.dao.IUserDao;
import com.xie.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author:Eric
 * DATE:2022/11/18-22:36
 * Decription: 单独建log类用于测试 事务的传播 REQUIRES_NEW
 */
@Component
public class LogServiceImpl  implements ILogService {
    @Autowired
    IUserDao userDao;
    @Override
    //如果事务传播行为是挂起事务 需要将父事务方法和子事务方法写在不同的类里面
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public void log() {
        userDao.sub();
        System.out.println("做了扣钱的事情");
    }
}
