package com.example.bootweb.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

/**
 * Created by jiangtenglong no 2018/1/9 .
 */
//@Configuration
public class RedisConfig {


//    @Bean
//    public RedisTemplate<String,Object> getRedisTemplent(RedisConnectionFactory redisConnectionFactory){
//        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
//        template.setValueSerializer(new GenericToStringSerializer<Long>(Long.class));
//        template.setKeySerializer(new GenericToStringSerializer<Long>(Long.class));
//        template.setConnectionFactory(redisConnectionFactory);
//        return template;
//    }
}
