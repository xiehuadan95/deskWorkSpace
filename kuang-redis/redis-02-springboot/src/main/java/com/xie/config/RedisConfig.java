package com.xie.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;

//固定模板
@Configuration
public class RedisConfig {
    //编写我们自己的reidsTemplate 将原有的<object,object>方式改为<String,object>方便使用
    @Bean
    //@ConditionalOnMissingBean(name = "redisTemplate")
    @SuppressWarnings("all") //跳过所有检查
    public RedisTemplate<String, Object> redisTemplate1(RedisConnectionFactory factory)
            throws UnknownHostException {
        //一般方便 直接使用<String, Object>
        RedisTemplate<String, Object> template = new RedisTemplate<String,Object>();
        //默认连接工厂
        template.setConnectionFactory(factory);
        //可以new jackson的redis序列化对象  自定义的jason序列化配置 用json去解析任意的对象
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
       //通过ObjectMapper 进行转译 转完之后就可以使用了
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        //String的序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        //key采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        //hash的key也采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        //value序列化方式采用jackson
        template.setValueSerializer(jackson2JsonRedisSerializer);
        //hash的value序列化方式采用jackson
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        /*配置具体的序列化方式,需要传参进去
        template.setKeySerializer(jackson2JsonRedisSerializer);*/
        //把所有的properties set进去
        template.afterPropertiesSet();
        return template;
    }
}
