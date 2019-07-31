package com.example.springsessiondemo.repository;

import com.example.springsessiondemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: Kayla, Ye
 * @Description:
 * @Date:Created in 3:18 PM 3/5/2019
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByAccount(String account);
    User findByAccountAndPassword(String account, String password);
}
