package com.xie.srb.core;

import com.xie.srb.core.mapper.DictMapper;
import com.xie.srb.core.pojo.entity.Dict;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Author:Eric
 * DATE:2023/2/14-21:59
 * Decription: Redis测试类
 */
//基础环境
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTemplateTest {

    //将redis注入进来
    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private DictMapper dictMapper;

    @Test
    public void saveDict(){
        Dict dict = dictMapper.selectById(20000);
        //jdk序列化 占用空间大 不安全 key也序列化
        //存字符串 存到dict 里面 可以序列化  5分钟过期 这个对象是序列化为字符串放进去
        redisTemplate.opsForValue().set("dict",dict, 5,TimeUnit.MINUTES);

    }
}
