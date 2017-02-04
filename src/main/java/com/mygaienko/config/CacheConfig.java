package com.mygaienko.config;

import com.mygaienko.model.dto.RequestDescription;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by enda1n on 04.02.2017.
 */
@Configuration
public class CacheConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
/*        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
        jedisConFactory.setHostName("localhost");
        jedisConFactory.setPort(6379);
        return jedisConFactory;*/

        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, RequestDescription> requestRedisTemplate() {
        RedisTemplate<String, RequestDescription> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

    @Bean
    public static RedisServerBean redisServer() {
        return new RedisServerBean();
    }
}
