package org.qifei.bone.pattern.observer.impl;

import org.qifei.bone.pattern.observer.CouponService;
import org.qifei.bone.pattern.observer.event.UserRegisterEvent;
import org.springframework.context.event.EventListener;
import org.springframework.retry.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/26 11:00
 * @Description 订阅事件
 */
@Service
public class CouponServiceImpl implements CouponService {
    @EventListener
    @CircuitBreaker
    public void addCoupon(UserRegisterEvent event) {
        String personId = event.getPersonId();
        System.out.println("优惠券***订阅成功-" + personId);
    }
}
