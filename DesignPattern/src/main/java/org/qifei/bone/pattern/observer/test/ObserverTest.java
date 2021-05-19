package org.qifei.bone.pattern.observer.test;

import org.junit.jupiter.api.Test;
import org.qifei.bone.pattern.constant.BizType;

import java.sql.SQLException;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/26 15:03
 * @Description
 */
public class ObserverTest {

    @Test
    public void testObserver () throws SQLException {
        /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(QiFeiConfig.class);
        UserService userService = context.getBean(UserService.class);
        CouponService couponService = context.getBean(CouponService.class);
        EmailService emailService = context.getBean(EmailService.class);

        userService.register("9750");*/
        System.out.println(BizType.TREND.equals(BizType.TREND));
    }
}
