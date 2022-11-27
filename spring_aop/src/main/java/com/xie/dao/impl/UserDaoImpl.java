package com.xie.dao.impl;

import com.xie.dao.IUserDao;
import com.xie.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Author:Eric
 * DATE:2022/11/13-9:25
 * Decription:数据访问层的具体实现类
 */
@Repository
public class UserDaoImpl implements IUserDao {
    @Override
    public User select(Integer id) throws Exception {
        if (id == null) {
            throw new Exception("id不能为null");
        }
        //访问数据库，查询User
        return new User();

    }

    @Override
    public void add(User user) throws Exception {
        if (user == null) {
            throw new Exception("user 不能为空！");
        }
        System.out.println("新增user成功！");
    }

    @Override
    public void update(User user) throws Exception {
        if (user == null) {
            throw new Exception("user 不能为空！");
        }
        System.out.println("更新成功！");
    }

    @Override
    public void delete(Integer id) throws Exception {
        if (id == null) {
            throw new Exception("id不能为null");
        }
        //访问数据库，查询User
        System.out.println("删除成功！");
    }
}
