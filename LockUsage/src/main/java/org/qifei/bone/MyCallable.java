package org.qifei.bone;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/12 14:15
 * @Description
 */
public class MyCallable implements Callable {
    @Override
    public String call() throws Exception {
        MyLock myLock = new MyLock();
        String lock = myLock.lockTry(new Random(10).toString());
        System.out.println(lock);
        return new Random(10).toString();
    }
}
