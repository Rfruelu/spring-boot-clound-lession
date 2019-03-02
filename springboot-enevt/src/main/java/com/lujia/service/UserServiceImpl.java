package com.lujia.service;

import com.lujia.domain.User;
import com.lujia.event.UserRegisterEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author :lujia
 * @date :2018/12/13  15:39
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public String register(User user) {

        /**
         * this 时间源
         */
        //通过 applicationContext 发布一个用户注册事件，监听了改事件的listener就用做出处理
        applicationContext.publishEvent(new UserRegisterEvent(this,user));
        return "success";
    }
}
