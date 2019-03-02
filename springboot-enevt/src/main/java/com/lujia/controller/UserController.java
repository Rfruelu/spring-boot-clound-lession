package com.lujia.controller;

import com.lujia.domain.User;
import com.lujia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :lujia
 * @date :2018/12/13  15:36
 */
@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @Async
    @RequestMapping("/user/register")
    public String register(User user){

         userService.register(user);
        return "success";
    }
}
