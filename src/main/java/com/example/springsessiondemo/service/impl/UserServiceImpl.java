package com.example.springsessiondemo.service.impl;

import com.example.springsessiondemo.constant.ErrorEnum;
import com.example.springsessiondemo.entity.User;
import com.example.springsessiondemo.repository.UserRepository;
import com.example.springsessiondemo.service.UserService;
import com.example.springsessiondemo.utils.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Kayla, Ye
 * @Description:
 * @Date:Created in 4:40 PM 7/31/2019
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByAccount(String account) {
        return userRepository.findByAccount(account);
    }

    @Override
    public ResponseObject login(String account, String password) {
        if(null == userRepository.findByAccountAndPassword(account,password)){
            return  ResponseObject.fail(ErrorEnum.PASSWORD_ERROR);
        }
        else return ResponseObject.success("ok");
    }
}
