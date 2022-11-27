package com.xie;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestJedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println("增加多个值："+jedis.mset("key","v","k2","v2","k3","v3","k4","v4"));
        System.out.println("获取多个值："+jedis.mget("key","k2"));
        System.out.println("删除多个键值对："+jedis.del("k4","k3"));
        jedis.flushDB();
        //不存在再设置，分布式锁
        System.out.println(jedis.setnx("key1","value"));
        System.out.println(jedis.setnx("key2","value2"));
        System.out.println(jedis.setnx("key3","value3"));
        System.out.println(jedis.get("key2"));
        //新增键值对，并设置过期时间
        System.out.println(jedis.setex("k",4,"v"));
        System.out.println(jedis.get("k"));
     /*   try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(jedis.get("k"));
        System.out.println("===========添加一个list=============");
        jedis.lpush("collections","ArrayList","vector","stack","haha");
        jedis.lpush("collections","tree");
        System.out.println("collections的所有内容："+jedis.lrange("collections",0,-1));
        System.out.println("collections的内容："+jedis.lrange("collections",0,3));
        System.out.println("collections左边出栈："+jedis.lpop("collections"));
        System.out.println("collections截取3个："+jedis.ltrim("collections",0,2));
        System.out.println("collections的所有内容："+jedis.lrange("collections",0,-1));
        jedis.lpush("list","2","0","0","3","9","200");
        System.out.println(jedis.lrange("list", 0, -1));
        List<String> sortList = jedis.sort("list");
        System.out.println("排序后："+sortList);
    }
}
