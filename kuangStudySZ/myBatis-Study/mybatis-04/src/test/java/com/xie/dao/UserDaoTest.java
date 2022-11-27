package com.xie.dao;

import com.xie.pojo.User;
import com.xie.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;



public class UserDaoTest {

   static Logger logger=Logger.getLogger(UserDaoTest.class);

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        //关闭资源
        sqlSession.close();
    }
@Test
    public void testLog4j(){
         System.out.println();
        logger.info("info:信息");
        logger.debug("debug:方式");
        logger.error("error:错误");
}

}
