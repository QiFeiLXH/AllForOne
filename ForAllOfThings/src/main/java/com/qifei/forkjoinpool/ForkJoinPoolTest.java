package com.qifei.forkjoinpool;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/25 15:25
 * @Description
 */
@Slf4j
public class ForkJoinPoolTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /**
         * 多线程框架
         */
        Executor executor = null;
        /**
         * Executor 的子接口
         */
        ExecutorService service = null;
        /**
         * ExecutorService 的抽象子类
         */
        AbstractExecutorService service1 = null;
        /**
         * AbstractExecutorService 的子类
         * 执行由一个大任务拆分成的多个小任务
         * 完成一个任务的分段执行, 最后再统一处理
         * 配合 ForkJoinTask 使用
         */
        ForkJoinPool xxxx = new ForkJoinPool();

        /**
         * 异步计算返回的结果
         */
        Future future = null;
        /**
         * Future的抽象子类
         */
        ForkJoinTask forkJoinTask = null;
        /**
         * 没有返回值, ForkJoinTask的抽象子类
         */
        RecursiveAction recursiveAction = null;
        /**
         * 有返回值, ForkJoinTask的抽象子类
         */
        RecursiveTask recursiveTask = null;

        /**
         * 来 300 个打印的任务
         */
        PrintTasks printTasks = new PrintTasks(0, 200);
        /**
         * 来一个任务存储器
         */
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        /**
         * 提交任务
         */
        forkJoinPool.submit(printTasks);
        /**
         * 等待所有任务完成
         */
        forkJoinPool.awaitTermination(20, TimeUnit.SECONDS);
        forkJoinPool.shutdown();

        int[] intArr = new int[100];
        Random random = new Random();
        int total = 0;
        int len = intArr.length;
        for (int i = 0; i < len ; i++) {
            int tmp = random.nextInt(5);
            total += (intArr[i] = tmp);
        }
        System.out.println("初始化时的数组总和 : " + total);
        SumTask sumTask = new SumTask(intArr, 0, len);
        /**
         * 通用池
         */
        ForkJoinPool pool = new ForkJoinPool(8);
        Integer result = pool.invoke(sumTask);
        System.out.println("任务执行结果: " + result);
        pool.shutdown();
    }
}
