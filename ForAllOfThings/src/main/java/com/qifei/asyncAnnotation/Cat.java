package com.qifei.asyncAnnotation;

/**
 * @Author Xuhui Lin
 * @Date 2021/2/25 10:32
 * @Description
 */
public class Cat implements IShout {
    @Override
    public void shout() {
        System.out.println("miao miao");
    }
}
