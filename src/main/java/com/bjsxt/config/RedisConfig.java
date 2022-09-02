package com.bjsxt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * 配置序列化器,默认jdk序列化方式,会乱码
 */
@Configuration    //原来的配置文件
public class RedisConfig {
    /**
     * 配置RedisTemplate序列化器
     */
    @Bean   //原来的bean标签    redis数据库相关的信息都封装到了RedisConnectionFactory内
    public RedisTemplate<String, Object> setRedisTemplate(RedisConnectionFactory factory) {
        //创建RedisTemplate
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        // 设置key的序列化方式
        template.setKeySerializer(RedisSerializer.string());
        // 设置value的序列化方式
        template.setValueSerializer(RedisSerializer.json());
        // 设置hash的key的序列化方式
        template.setHashKeySerializer(RedisSerializer.string());
        // 设置hash的value的序列化方式
        template.setHashValueSerializer(RedisSerializer.json());
        template.afterPropertiesSet();
        return template;
    }
}