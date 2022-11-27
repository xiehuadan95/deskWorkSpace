package com.xie.security01.mapper;


import com.xie.security01.dao.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author Fox
 */
@Repository
public interface UserMapper {

    @Select("select * from tb_user where username=#{username}")
    User getByUsername(String username);
}
