package org.qifei.bone.pattern.observer.impl;

import org.qifei.bone.pattern.observer.EmailService;
import org.qifei.bone.pattern.observer.event.UserRegisterEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/26 10:58
 * @Description 订阅事件
 */
@Service
public class EmailServiceImpl implements EmailService, ApplicationListener<UserRegisterEvent> {
    @Override
    @Retryable(maxAttempts=5,backoff = @Backoff(delay = 3000))
    public void onApplicationEvent(UserRegisterEvent event) {
        System.out.println(11111);
        String personId = event.getPersonId();
        if (personId.equals("9755")) {
            throw new RuntimeException("异常咯");
        }
        System.out.println("邮件方***订阅成功-" + personId);
    }

    @Recover
    public void recover () {
        System.out.println("邮件恢复中");
    }

}
