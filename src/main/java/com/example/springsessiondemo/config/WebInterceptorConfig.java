package com.example.springsessiondemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Kayla, Ye
 * @Description:
 * @Date:Created in 10:33 PM 7/31/2019
 */
@Configuration
public class WebInterceptorConfig  implements WebMvcConfigurer {
    @Bean
    SecurityInterceptor securityInterceptor(){return  new SecurityInterceptor(); }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(securityInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/logout")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/test/**")
                .excludePathPatterns("/swagger-ui.html")
                .excludePathPatterns("/swagger-ui.html#/")
                .excludePathPatterns("/swagger-ui.html#/**")
                .excludePathPatterns("/webjars/**")
                .excludePathPatterns("/swagger-resources/**");
    }
}
