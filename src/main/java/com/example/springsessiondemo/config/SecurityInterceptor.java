package com.example.springsessiondemo.config;

import com.alibaba.fastjson.JSON;
import com.example.springsessiondemo.utils.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: Kayla, Ye
 * @Description:
 * @Date:Created in 10:35 PM 7/31/2019
 */
@Configuration
public class SecurityInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(SecurityInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute(session.getId()) != null){
            logger.info("已登录");
            return true;
        }
        logger.info("已登出");
        response.getWriter().write(JSON.toJSONString(
                new ResponseObject(){{
                   setCode(40001);
                   setMsg("please login first");
                }}
        ));
        return false;
    }

}
