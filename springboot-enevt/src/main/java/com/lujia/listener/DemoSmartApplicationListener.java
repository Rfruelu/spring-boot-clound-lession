package com.lujia.listener;

import com.lujia.domain.User;
import com.lujia.event.UserRegisterEvent;
import com.lujia.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * public interface SmartApplicationListener extends ApplicationListener<ApplicationEvent>, Ordered {
 *
 * SmartApplicationListener  默认是监听所有类型的事件，<ApplicationEvent>
 * @author :lujia
 * @date :2018/12/13  16:21
 */
@Slf4j
@Component
public class DemoSmartApplicationListener implements SmartApplicationListener {


    /**
     * 事件对面类型匹配
     * 该方法返回true 并且 supportsSourceType 返回true 时才会调用onApplicationEvent 处理监听
     * @param aClass
     * @return
     */
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {

        return aClass== UserRegisterEvent.class;
    }

    /**
     * 事件源对象类型匹配
     * @param sourceType
     * @return
     */
    @Override
    public boolean supportsSourceType(Class<?> sourceType) {

        return sourceType==UserServiceImpl.class;
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
        log.info("0000--注册成功--{}",user);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
