package org.qifei.proxy;

import java.lang.reflect.Proxy;

/**
 * @Author Xuhui Lin
 * @Date 2021/5/8 14:43
 * @Description
 */
public class TestJDKProxy {
    public static void main(String[] args) {
        Animal animal = new Dog();
        Animal dog = (Animal)Proxy.newProxyInstance(animal.getClass().getClassLoader(), animal.getClass().getInterfaces(), new MyJDKProxy(animal));
        dog.run();
    }
}
