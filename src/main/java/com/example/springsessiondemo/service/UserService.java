package com.example.springsessiondemo.service;


import com.example.springsessiondemo.entity.User;
import com.example.springsessiondemo.utils.ResponseObject;

/**
 * @Author: Kayla, Ye
 * @Description:
 * @Date:Created in 4:34 PM 7/31/2019
 */
public interface UserService {
    /**
     * save user
     * @param user
     * @return 保存后的用户信息
     */
    User saveUser(User user);

    /**
     * find user by account
     * @param account
     * @return
     */
    User findByAccount(String account);

    /**
     * user login
     * @param account
     * @param password
     * @return
     */
    ResponseObject login(String account, String password);
}
