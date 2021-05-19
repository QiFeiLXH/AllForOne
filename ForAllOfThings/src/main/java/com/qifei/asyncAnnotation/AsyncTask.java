package com.qifei.asyncAnnotation;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/10 9:45
 * @Description
 */
@Component
public class AsyncTask {

    @Async
    public Future<String> task1 () throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long total = System.currentTimeMillis() - start;
        System.out.println("共耗时： " + total);
        return new AsyncResult<String>("task1执行完毕！");
    }

    @Async
    public Future<String> task2 () throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long total = System.currentTimeMillis() - start;
        System.out.println("共耗时： " + total);
        return new AsyncResult<String>("task2执行完毕！");
    }

    @Async
    public Future<String> task3 () throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long total = System.currentTimeMillis() - start;
        System.out.println("共耗时： " + total);
        return new AsyncResult<String>("task3执行完毕！");
    }

}
