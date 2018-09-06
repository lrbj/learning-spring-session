package com.example.springsessiondemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.DefaultCookieSerializer;

import static org.springframework.session.data.redis.RedisFlushMode.IMMEDIATE;
import static org.springframework.session.data.redis.RedisFlushMode.ON_SAVE;


/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 4:01 PM 8/31/2018
 */
@Configuration
@EnableRedisHttpSession
public class HttpSessionConfig {
    @Value ("${spring.redis.host}")
    private String hostname;

    @Value("${spring.redis.port}")
    private int port;

    @Value ("${spring.redis.database}")
    private int database;

    @Bean
    public LettuceConnectionFactory connectionFactory(){
        LettuceConnectionFactory lettuceConnectionFactory =new LettuceConnectionFactory ();
        lettuceConnectionFactory.setDatabase (database);
        lettuceConnectionFactory.setHostName (hostname);
        lettuceConnectionFactory.setPort (port);
        return lettuceConnectionFactory;
    }


}
