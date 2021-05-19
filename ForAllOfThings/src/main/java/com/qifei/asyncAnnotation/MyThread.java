package com.qifei.asyncAnnotation;

import java.util.concurrent.Callable;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/5 17:27
 * @Description
 */
public class MyThread implements Callable {
    @Override
    public Person call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return new Person("aa", "bb");
    }
}
