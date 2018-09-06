package com.example.springsessiondemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

import static org.springframework.session.data.redis.RedisFlushMode.IMMEDIATE;
import static org.springframework.session.data.redis.RedisFlushMode.ON_SAVE;


/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 4:01 PM 8/31/2018
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 300)//session过期时间
public class SessionConfig {
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

    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName("JSESSIONID"); // <1>
        serializer.setCookiePath("/"); // <2>
        serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$"); // <3>
        return serializer;
    }

}
