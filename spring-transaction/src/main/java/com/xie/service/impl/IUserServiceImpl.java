package com.xie.service.impl;

import com.xie.dao.IUserDao;
import com.xie.entity.User;
import com.xie.service.ILogService;
import com.xie.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author:Eric
 * DATE:2022/11/15-21:39
 * Decription:
 */
@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    IUserDao userDao;
    @Autowired
    ILogService logService;

    /**
     *转账
     * @return
     */

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ,timeout = 2)
    public void trans(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logService.log();
        //lilei 扣钱
        sub();
        int i=1/0;
        //lily 加钱
        save();
    }

    /**
     * 扣钱
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void sub(){
        System.out.println("lilei扣钱200元转给lily====");
        userDao.sub();
    }

    /**
     * 存钱
     */
    public void save(){
        System.out.println("lily获得lilei的200元转账====");
        userDao.save();
    }



    @Override
    public User getUser(){
        return userDao.getUser();
    }

}
