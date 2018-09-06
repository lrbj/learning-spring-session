package com.example.springsessiondemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Base64;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 2:40 PM 8/31/2018
 */
@RestController
public class CookieController
{

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/test/cookie")
    public  String cookie(@RequestParam("browser") String  browser,HttpServletRequest request,HttpSession session){


        /**
         * 1 、取出session中的browser
         * 2、如果没有则将request 中的borwser 存入session
         * 3、如果获取到session ,则将request 中的browser 输出
         * 4、 打印所有的cookie
         **/
        Object sessionBrower = session.getAttribute ("browser");
        if( sessionBrower == null ){
            System.out.println ("不存在session, 设置browser=" + browser);
            session.setAttribute ("browser", browser);
        }else {
            System.out.println ("存在session, browser="+ sessionBrower.toString ());
        }

        Cookie[] cookies = request.getCookies ();
        if (cookies != null && cookies.length > 0){
            for (Cookie cookie: cookies){
                System.out.println (cookie.getName ()+":"+cookie.getValue ());
            }
        }

        return  "index";
    }

    @RequestMapping("/set")
    String set(HttpServletRequest req) {
        req.getSession().setAttribute("testKey", "testValue");
        System.out.println ("setSession");
        String sessionId =   req.getSession().getId ();
        System.out.println ("sessionId="+ sessionId);
        Cookie[] cookies = req.getCookies ();
        if (cookies != null && cookies.length > 0){
            for (Cookie cookie: cookies){
                System.out.println (cookie.getName ()+":"+cookie.getValue ());
            }
        }

        String token = UUID.randomUUID ().toString ();
        Integer expire = 1;
        stringRedisTemplate.opsForValue ().set (String.format ("token",token ),
                "123",
                expire,
                TimeUnit.SECONDS);

        return "set session:testKey=testValue";
    }

    @RequestMapping("/query")
    String query(HttpServletRequest req) {
        HttpSession session =  req.getSession();
        Object value = session.getAttribute("testKey");
        System.out.println ("query session");
        String sessionId = session.getId ();
        System.out.println ("sessionId="+ sessionId);
        Cookie[] cookies = req.getCookies ();
        if (cookies != null && cookies.length > 0){
            for (Cookie cookie: cookies){
                System.out.println (cookie.getName ()+":"+cookie.getValue ());
                byte[] decodedCookieBytes = Base64.getDecoder().decode(cookie.getValue ());
                String  decodeSeesionId = new String(decodedCookieBytes);
                System.out.println (cookie.getName ()+"："+  decodeSeesionId);
            }
        }

        return "query Session：\"testKey\"=" + value;
    }
}
