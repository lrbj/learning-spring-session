package com.example.springsessiondemo.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @Author: Kayla, Ye
 * @Description:
 * @Date:Created in 3:05 PM 3/5/2019
 */
@Data
@Entity
@Table(name = "test_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotBlank(message = "account can not be empty")
    private String account;
    @NotBlank(message = "password can not be empty")
    private String password;
    @NotBlank(message = "name can not be empty")
    private String name;

    //省略getter、setter
}