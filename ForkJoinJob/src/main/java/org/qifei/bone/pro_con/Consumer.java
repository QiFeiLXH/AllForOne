package org.qifei.bone.pro_con;

import java.util.concurrent.BlockingQueue;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/9 10:31
 * @Description
 */
public class Consumer implements Runnable {
    private final BlockingQueue queue;

    Consumer(BlockingQueue q) {
        queue = q;
    }

    public void run() {
        try {
            while (true) {
                consume(queue.take());
            }
        } catch (InterruptedException ex) {
        }
    }

    void consume(Object x) {

    }
}
