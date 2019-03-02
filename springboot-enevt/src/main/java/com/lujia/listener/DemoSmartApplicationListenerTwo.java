package com.lujia.listener;

import com.lujia.domain.User;
import com.lujia.event.UserRegisterEvent;
import com.lujia.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author :lujia
 * @date :2018/12/13  16:30
 */
@Slf4j
@Component
public class DemoSmartApplicationListenerTwo implements SmartApplicationListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {

        return aClass.equals(UserRegisterEvent.class);
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return sourceType.equals(UserServiceImpl.class);
    }

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {

        UserRegisterEvent userRegisterEvent=(UserRegisterEvent) applicationEvent;

        User user = userRegisterEvent.getUser();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("1111--发送邮件--{}",user);

    }
}
