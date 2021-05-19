package org.qifei.bone.pro_con;

import java.util.concurrent.BlockingQueue;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/9 10:29
 * @Description
 */
public class Producer implements Runnable {
    private final BlockingQueue queue;

    Producer(BlockingQueue q) {
        queue = q;
    }

    public void run() {
        try {
            while (true) {
                queue.put(produce());
            }
        } catch (InterruptedException ex) {
        }
    }

    Object produce() {
        return null;
    }
}
