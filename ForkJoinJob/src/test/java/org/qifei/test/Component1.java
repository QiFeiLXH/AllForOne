package org.qifei.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/22 16:07
 * @Description
 */
@Component
public class Component1 {
    @Autowired
    private Component2 c2;

//    public Component1(Component2 c2) {
//
//    }

    public void m1() {
        System.out.println(c2.toString());
    }
}
