package com.example.springsessiondemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 4:01 PM 8/31/2018
 */
@Configuration
@EnableRedisHttpSession
public class HttpSessionConfig {
    @Bean
    public LettuceConnectionFactory connectionFactory(){
        return  new LettuceConnectionFactory ();
    }
}
