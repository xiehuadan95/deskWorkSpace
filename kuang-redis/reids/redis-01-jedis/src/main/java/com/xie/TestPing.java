package com.xie;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class TestPing {
    public static void main(String[] args) {
        //2.new Jedis 对象 此处以本地连接为例
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //jedis所有的命令 就是之前学的redis命令 在java里都是一个一个的方法
        System.out.println(jedis.ping());
        System.out.println("清空数据："+jedis.flushDB());
        System.out.println("判断值是否存在"+jedis.exists("username"));
        System.out.println("新增键值对"+jedis.set("username","eric"));
        System.out.println("新增键值对"+jedis.set("password","123456"));
        //所有的键
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        //删除
        jedis.del("password");
        //判断是否存在
        System.out.println(jedis.exists("password"));
        System.out.println("查看所存储的值的类型:"+jedis.type("username"));
        System.out.println("随机返回key空间的一个:"+jedis.randomKey());
        System.out.println("重命名key:"+jedis.rename("username","name"));
        System.out.println("获取值:"+jedis.get("name"));
        System.out.println("按索引查询:"+jedis.select(0));
        System.out.println("返回当前数据库key的数目："+jedis.dbSize());
        System.out.println("删除所有数据库中的所有key:"+jedis.flushAll());
    }
}
