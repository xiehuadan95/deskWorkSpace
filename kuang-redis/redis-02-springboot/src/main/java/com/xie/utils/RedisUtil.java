package com.xie.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//真实开发中都会有一个自己的工具
@Component
public final class RedisUtil {
    //注入自己定义的redisTemplate
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 指定缓存失效时间
     * @param key  键
     * @param time 时间(秒)
     * @return
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据 key 获取过期时间
     * @param key 键不能为null
     * @return 时间（秒） 返回0代表为永久有效
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断key 是否存在
     * @param key 键
     * @return true 存在  false 不存在
     */
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除
     * @param key 可以传一个 或多个
     */
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                //重载的delete方法 里面需要传入的是集合 用集合工具类 将key 转为集合list
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * 普通缓存的获取
     * @param key 键
     * @return value 值
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存放入
     * @param key   键
     * @param value 值
     * @return true成功  false失败
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 普通缓存放入并设置时间
     * @param key   键
     * @param value 值
     * @param time  时间（秒）time要大于0，如果time小于等于0 将设置无限制
     * @return true成功  false失败
     */
    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 递增
     * @param key   键
     * @param delta 要增加几（大于0）
     * @return
     */
    public long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 递减
     * @param key   键
     * @param delta 要减少几（小于0）
     * @return
     */
    public long decr(String key, long delta) {
        if (delta > 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().decrement(key, -delta);
    }

    /**
     * HashGet
     * @param key    键 不能为null
     * @param item   项 不能为null
     * @return
     */
    public Object hget(String key,String item){
        return redisTemplate.opsForHash().get(key,item);
    }

    /**
     * 获取hashKey 对应的所有键值
     * @param key  键
     * @return  对应的多条记录
     */
    public Map<Object,Object> hmget(String key){
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * HashSet
     * @param key  键
     * @param map  对应多个键值
     * @return true false
     */
    public boolean hmset(String key,Map<String,Object> map){
        try {
            redisTemplate.opsForHash().putAll(key,map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * HashSet 并设置时间
     * @param key   键
     * @param map   对应多个键值
     * @param time  时间（秒）
     * @return  true false
     */
    public boolean hmset(String key,Map<String,Object> map,long time){
        try {
            redisTemplate.opsForHash().putAll(key,map);
            if(time>0){
                expire(key,time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 向一张hash表 中存入数据，如果不存在将创建
     * @param key     键
     * @param item    项（hash表里面的 k）
     * @param value   值
     * @return  true成功 false失败
     */
    public boolean hset(String key,String item,Object value){
        try {
            redisTemplate.opsForHash().put(key,item,value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 向一张hash表 中存入数据，如果不存在将创建
     * 并设置过期时间 （如果传入有时间）
     * @param key     键
     * @param item    项（hash表里面的 k）
     * @param value   值
     * @param time    时间（秒） 注意：如果已经存在的hash表有时间，这里将会替换原有时间
     * @return true false
     */
    public boolean hset(String key,String item,Object value,long time){
        try {
            redisTemplate.opsForHash().put(key,item,value);
            if(time>0){
                expire(key,time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除hash表中的元素
     * @param key  键
     * @param item 元素 可以是多个，但是不能为null
     */
    public void hdel(String key,Object... item){
        redisTemplate.opsForHash().delete(key,item);
    }

    /**
     * 判断hash表中是否有该项的值
     * @param key   键 不能为null
     * @param item  项 不能为null
     * @return true存在 false 不存在
     */
    public boolean hHashKey(String key,String item){
        return redisTemplate.opsForHash().hasKey(key,item);
    }

    /**
     * hash 递增 如果不存在就会创建一个并把新增后的值返回
     * @param key   键
     * @param item  项
     * @param incr   要增加几（大于0，步长）double类型
     * @return
     */
    public double hincr(String key,String item,double incr){
        return redisTemplate.opsForHash().increment(key,item,incr);
    }

    /**
     *hash 递减
     * @param key   键
     * @param item  项
     * @param decr  要减少几
     * @return
     */
    public double hdecr(String key,String item,double decr){
        return  redisTemplate.opsForHash().increment(key,item,-decr);
    }
    //---------------------------------------------------------

    /**
     * 根据key 获取Set集合中的所有值
     * @param key  键
     * @return Set<Object>
     */
    public Set<Object> sGet(String key){
        try {
            return  redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据value 从一个set中查询，是否存在
     * @param key     键
     * @param value   值
     * @return true存在 false不存在
     */
    public boolean sHasKey(String key,Object value){
        try {
            return redisTemplate.opsForSet().isMember(key,value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将数据放入set 缓存
     * @param key     键
     * @param values  值  可以是多个
     * @return 成功个数
     */
    public long sSet(String key,Object... values){
        try {
            return redisTemplate.opsForSet().add(key,values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 将set数据放入缓存
     * @param key    键
     * @param time   时间
     * @param values 值 可多个
     * @return  成功个数
     */
    public long sSetAndTime(String key,long time,Object... values){
        try {
            Long count=redisTemplate.opsForSet().add(key,values);
            if(time>0) {
                expire(key, time);
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取set缓存的长度
     * @param key 键
     * @return
     */
    public long sGetSetSize(String key){
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 移除值为value的
     * @param key     键
     * @param values  值，可以是多个
     * @return 移除的个数
     */
    public long setRemove(String key,Object... values){
        try {
            Long count = redisTemplate.opsForSet().remove(key, values);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
//----------list---------

    /**
     * 获取list缓存的内容
     * @param key    键
     * @param start  开始
     * @param end    结束  0 到 -1代表所有的值
     * @return
     */
    public List<Object> lGet(String key,long start,long end){
        try {
            return redisTemplate.opsForList().range(key,start,end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取list缓存 的长度
     * @param key  键
     * @return 长度
     */
    public long lGetListSize(String key){
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 通过索引 获取list中的值
     * @param key     键
     * @param index   索引 index>=0 时，0表示头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @return
     */
    public Object lGetIndex(String key,long index){
        try {
            return redisTemplate.opsForList().index(key,index);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将list 放入缓存
     * @param key     键
     * @param value   值
     * @return
     */
    public boolean lSet(String key,Object value){
        try {
            redisTemplate.opsForList().rightPush(key,value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list 放入缓存，且可以设置过期时间
     * @param key      键
     * @param value    值
     * @param time     过期时间（秒）
     * @return
     */
    public boolean lSet(String key,Object value,long time){
        try {
            redisTemplate.opsForList().rightPush(key,value);
            if(time>0){
                expire(key,time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list 放入缓存
     * @param key      键
     * @param values   值
     * @return
     */
    public boolean lSet(String key,List<Object> values){
        try {
            redisTemplate.opsForList().rightPushAll(key,values);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list 放入缓存
     * @param key      键
     * @param values   值
     * @param time     时间（秒）
     * @return
     */
    public boolean lSet(String key,List<Object> values,long time){
        try {
            redisTemplate.opsForList().rightPushAll(key,values);
            if(time>0){
                expire(key,time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据索引修改list中的某条数据
     * @param key     键
     * @param index   索引
     * @param value   值
     * @return
     */
    public boolean lUpdateIndex(String key,long index,Object value){
        try {
            redisTemplate.opsForList().set(key,index,value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 移除 列表中多个值 为value的元素
     * @param key    键
     * @param count  数量
     * @param value  值
     * @return  移除的个数
     */
    public long lRemove(String key,long count,Object value){
        try {
            Long remove = redisTemplate.opsForList().remove(key, count, value);
            return remove;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
