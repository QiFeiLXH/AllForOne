package com.qifei.asyncAnnotation;

/**
 * @Author Xuhui Lin
 * @Date 2021/2/25 10:33
 * @Description
 */
public class Dog implements IShout {
    @Override
    public void shout() {
        System.out.println("wang wang");
    }
}
