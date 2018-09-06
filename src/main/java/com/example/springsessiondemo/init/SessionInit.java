package com.example.springsessiondemo.init;

import jdk.nashorn.internal.runtime.regexp.joni.Config;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 3:58 PM 9/5/2018
 */
public class SessionInit extends AbstractHttpSessionApplicationInitializer {

    public SessionInit() {
        super (Config.class);
    }

}