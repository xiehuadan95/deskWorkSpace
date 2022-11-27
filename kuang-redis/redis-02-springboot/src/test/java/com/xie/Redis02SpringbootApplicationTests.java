package com.xie;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xie.pojo.User;
import com.xie.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class Redis02SpringbootApplicationTests {
    //将自带的模板进行注入 使用
    @Autowired
    @Qualifier("redisTemplate1") //可能有定义多个模板，可通过名字指定注入
    private RedisTemplate redisTemplate;
    //一般也会写一个RedisUtils 来使用
    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {
       // opsForValue() 操作字符串类似String 类型
        //opsForList() 操作list类型
        //opsForSet() opsForHash() opsForGeo() opsForZSet() opsForHyperLogLog
        //redisTemplate.opsForList().leftPop()
        //常用的方法，直接通过redisTemplate来操作，比如事务，执行，取消

        //去操作关于数据库的连接 获取连接对象
        /*RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.flushDb();
        connection.flushAll();*/
        redisTemplate.opsForValue().set("mykey","helloWorld");
        System.out.println(redisTemplate.opsForValue().get("mykey"));

    }
    //测试没有序列化
    @Test
    public  void test() throws JsonProcessingException {
        User lily = new User("lily", 18);
        //jackson帮忙序列化 变成json
        String jsonLily = new ObjectMapper().writeValueAsString(lily);
        System.out.println("jackson方式："+jsonLily);
        //fastJson
        System.out.println("fastJson转换方式："+JSON.toJSONString(lily));
        redisTemplate.opsForValue().set("user",jsonLily);
        System.out.println(redisTemplate.opsForValue().get("user"));
        //{"name":"lily","age":18}
        //如果不转换直接传对象进来
        redisTemplate.opsForValue().set("user1",lily);
        System.out.println(redisTemplate.opsForValue().get("user1"));

    }
    //redis工具类的使用
    @Test
    public String testRedis() {
        redisUtil.set("name", "lala");
        System.out.println(redisUtil.get("name"));
        Boolean locky = redisTemplate.opsForValue().setIfAbsent("locky", "uuid", 30, TimeUnit.SECONDS);
        if (!locky) {
            return "error-code";
        }
        try {
            System.out.println("获取到分布式锁======");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ("uuid".equals(redisTemplate.opsForValue().get("locky"))) {
                redisTemplate.delete("locky");
            }
        }
        return "success!";
    }
}
