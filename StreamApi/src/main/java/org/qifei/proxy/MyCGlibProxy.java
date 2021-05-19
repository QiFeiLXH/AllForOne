package org.qifei.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author Xuhui Lin
 * @Date 2021/5/8 14:57
 * @Description
 */
public class MyCGlibProxy implements MethodInterceptor {
    private Animal animal;
    public MyCGlibProxy(Animal animal) {
        this.animal = animal;
    }
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB 开始咯****************");
        Object result = method.invoke(animal, args);
        System.out.println("CGLIB 结束咯****************");
        return result;
    }

    public static void main(String[] args) {
        Animal animal = new Dog();
        MyCGlibProxy myCGlibProxy = new MyCGlibProxy(animal);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Animal.class);
        enhancer.setCallback(myCGlibProxy);
        Animal dog = (Animal)enhancer.create();
        dog.run();
    }
}
