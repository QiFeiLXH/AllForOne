package org.qifei.bone;

import java.util.concurrent.FutureTask;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        MyCallable myCallable1 = new MyCallable();
        MyCallable myCallable2 = new MyCallable();
        FutureTask task1 = new FutureTask(myCallable1);
        FutureTask task2 = new FutureTask(myCallable2);
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        thread1.start();
        thread2.start();
    }
}
