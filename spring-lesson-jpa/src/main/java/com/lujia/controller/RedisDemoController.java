package com.lujia.controller;

import com.lujia.domain.User;
import com.lujia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author :lujia
 * @date :2018/11/26  15:32
 */
@RestController
@RequestMapping("/redis/cache")
public class RedisDemoController {


    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }
}
