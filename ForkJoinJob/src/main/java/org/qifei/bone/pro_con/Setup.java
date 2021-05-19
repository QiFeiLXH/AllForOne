package org.qifei.bone.pro_con;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/9 10:32
 * @Description
 */
public class Setup {
    void main() {
        BlockingQueue q = new SynchronousQueue();
        Producer p = new Producer(q);
        Consumer c1 = new Consumer(q);
        Consumer c2 = new Consumer(q);
        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c2).start();
    }
}
