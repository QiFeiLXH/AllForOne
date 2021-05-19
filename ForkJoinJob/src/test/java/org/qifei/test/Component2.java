package org.qifei.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/22 16:07
 * @Description
 */
@Component
public class Component2 {
    @Autowired
    private Component1 c1;

    public void m2() {
        System.out.println(c1.toString());
    }
}
