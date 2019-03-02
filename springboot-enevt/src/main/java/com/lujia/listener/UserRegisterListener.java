//package com.lujia.listener;
//
//import com.lujia.domain.User;
//import com.lujia.event.UserRegisterEvent;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.ApplicationListener;
//import org.springframework.stereotype.Component;
//
///**
// * @author :lujia
// * @date :2018/12/13  15:26
// */
//@Component
//@Slf4j
//public class UserRegisterListener implements ApplicationListener<UserRegisterEvent> {
//
//    /**
//     * UserRegisterEvent 事件监听，实现ApplicationListener 并重写onApplicationEvent 就可以实现监听的效果
//     * @param userRegisterEvent
//     */
//    @Override
//    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
//        log.info("用户注册成功----");
//        User user = userRegisterEvent.getUser();
//        log.info("name-{}--password--{}",user.getName(),user.getPassword());
//
//    }
//}
