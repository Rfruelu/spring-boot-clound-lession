//package com.lujia.listener;
//
//import com.lujia.domain.User;
//import com.lujia.event.UserRegisterEvent;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//
///**
// * @author :lujia
// * @date :2018/12/13  15:50
// */
//
//@Component
//@Slf4j
//public class SendEmailListener {
//
//    /**
//     * 注解事件监听--监听用户注册事件
//     * @param registerEvent
//     * @return
//     */
//    @EventListener
//    public String sendEmail(UserRegisterEvent registerEvent){
//
//        User user = registerEvent.getUser();
//        log.info("send email --name--{}--password--{}",user.getName(),user.getPassword());
//        return "send mail success";
//    }
//
//}
