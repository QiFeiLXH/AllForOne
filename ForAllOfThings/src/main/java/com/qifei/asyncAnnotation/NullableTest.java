package com.qifei.asyncAnnotation;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/5 16:04
 * @Description
 */
public class NullableTest {
    public static void main(String[] args) throws Exception {
        /*new ConcurrentHashMap<>();
        new CopyOnWriteArrayList<>();*/
        MyThread myThread = new MyThread();
        FutureTask<Person> futureTask = new FutureTask<>(myThread);
        futureTask.run();
        Person person = futureTask.get();
        System.out.println(person);
    }

    @Test
    public void test3() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);
// 创建多个有返回值的任务
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < 5; i++) {
            Callable c = new MyThread();
// 执行任务并获取 Future 对象
            Future f = pool.submit(c);
            list.add(f);
        }
// 关闭线程池
        pool.shutdown();
// 获取所有并发任务的运行结果
        for (Future f : list) {
// 从 Future 对象上获取任务的返回值，并输出到控制台
            System.out.println("res：" + f.get().toString());
        }
    }

    private static int[] test2() {
        int[] ret = new int[]{0};
        try {
            return ret;  // 返回 0，finally内的修改效果不起作用
        } finally {
            ret[0]++;
            System.out.println("finally执行");
        }
    }

    private static int test1() {
        int ret = 0;
        try {
            return ret;  // 返回 0，finally内的修改效果不起作用
        } finally {
            ret++;
            System.out.println("finally执行");
        }
    }

    @Test
    public void test6() {
        Executors.newCachedThreadPool();
    }

}
