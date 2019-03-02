package com.lujia.event;

import com.lujia.domain.User;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 *  事件的监听处理是同步的，必须等待listener处理完成之后，才会响应
 * @author :lujia
 * @date :2018/12/13  15:20
 */
@Data
public class UserRegisterEvent extends ApplicationEvent {


    private User user;

    /**
     * 用户注册事件， 只要继承ApplicationEvent 并重写构造函数public ApplicationEvent(Object source)
     * @param source
     * @param user
     */
    public UserRegisterEvent(Object source,User user) {
        super(source);
        this.user=user;
    }
}
