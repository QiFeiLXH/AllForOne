package org.qifei.bone;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/12 14:13
 * @Description
 */
public class MyLock {
    public String lockTry(String str) {
        System.out.println(Thread.currentThread().getName() + "已准备");
        synchronized (str) {
            System.out.println(Thread.currentThread().getName() + "进入锁");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {

            }
            return Thread.currentThread().getName() + "--" + str;
        }
    }
}
