package com.xie;

import org.json.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

//事务
public class TextTX {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushDB();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello","world");
        jsonObject.put("name","lily");
        jsonObject.put("age","18");
        //开启事务
        Transaction multi = jedis.multi();
        String s = jsonObject.toString();
        System.out.println("json串数据为："+s);
        //模拟监控
        jedis.watch("s");
        try {
            multi.set("user",s);
            multi.set("user1",s);
            //模拟失败
           // int i = 1/0;
            multi.exec();
        } catch (Exception e) {
            //如果失败有异常，放弃事务
            multi.discard();
            e.printStackTrace();
        }finally {
            System.out.println(jedis.get("user"));
            System.out.println(jedis.get("user1"));
            //执行完毕，关闭连接
            jedis.close();
        }
    }
}
