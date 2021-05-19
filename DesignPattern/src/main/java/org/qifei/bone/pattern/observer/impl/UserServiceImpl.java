package org.qifei.bone.pattern.observer.impl;

import org.qifei.bone.pattern.observer.UserService;
import org.qifei.bone.pattern.observer.event.UserRegisterEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/26 10:55
 * @Description 可发布事件
 */
@Service
public class UserServiceImpl implements UserService, ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void register(String personId) throws SQLException {
        System.out.println(2222);
        System.out.println("保存成功-" + personId);
        System.out.println("开始通知！");
        if (personId.equals("9750")) {
            throw new SQLException("SQLException");
        }
        applicationEventPublisher.publishEvent(new UserRegisterEvent(this, personId));
    }
}
