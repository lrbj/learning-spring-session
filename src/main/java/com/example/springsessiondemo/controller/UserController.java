package com.example.springsessiondemo.controller;

import com.example.springsessiondemo.entity.User;
import com.example.springsessiondemo.service.UserService;
import com.example.springsessiondemo.utils.ResponseObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: Kayla, Ye
 * @Description:
 * @Date:Created in 4:46 PM 7/31/2019
 */
@RestController
@RequestMapping(value = "/user")
@Api(tags = "user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * save user
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/save")
    @ApiOperation(value = "保存用户")
    public User save(@RequestBody User user) {
        return userService.saveUser(user);
    }

    /**
     * find user by account
     *
     * @param account
     * @return
     */
    @PostMapping(value = "/find/{account}")
    @ApiOperation(value = "查询")
    public User find(@PathVariable String account) {
        return userService.findByAccount(account);
    }

    /**
     * user login
     *
     * @param account
     * @param password
     * @return
     */
    @PostMapping(value = "/login")
    @ApiOperation(value = "登入")
    public ResponseObject login(String account, String password,HttpServletRequest req) {
        ResponseObject object =  userService.login(account, password);
        if(200 == object.getCode()){
            HttpSession session = req.getSession();
            session.setAttribute(session.getId(), object.getData());
        }

        return  object;
    }

    @PostMapping(value = "/logout")
    @ApiOperation(value = "登出")
    public void logout(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.removeAttribute(session.getId());
    }


}