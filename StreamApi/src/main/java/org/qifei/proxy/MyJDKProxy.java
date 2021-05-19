package org.qifei.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author Xuhui Lin
 * @Date 2021/5/8 14:37
 * @Description
 */
public class MyJDKProxy implements InvocationHandler {
    private Animal animal;
    public MyJDKProxy(Animal animal) {
        this.animal = animal;
    }
    @Override
    public Object invoke(Object target, Method method, Object[] args) throws Throwable {
        System.out.println("开始咯****************");
        Object result = method.invoke(animal, args);
        System.out.println("结束咯****************");
        return result;
    }

}
