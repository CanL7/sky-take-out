package com.sky.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@Slf4j
public class RedisConfiguration {

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        log.info("正在创建RedisTemplate对象");
        //先新建一个RedisTemplate对象
        RedisTemplate redisTemplate = new RedisTemplate();
        //设置一个链接工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //设置String序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //返回RedisTemplate对象
        return redisTemplate;
    }
}
