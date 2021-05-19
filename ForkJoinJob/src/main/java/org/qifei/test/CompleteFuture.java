package org.qifei.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/28 15:08
 * @Description
 */
@Component
public class CompleteFuture {
    @Autowired
    private CustomService customService;

    // 开始执行1
    //1609140836712
    //1
    //开始执行2
    //1609140837713
    //2
    public void execute () {
        long start = System.currentTimeMillis();
        System.out.println("开始执行1");
        Integer one = customService.queryOne();
        System.out.println(one);
        System.out.println("开始执行2");
        Integer two = customService.queryTwo();
        System.out.println(two);
        System.out.println("总共耗时：" + (System.currentTimeMillis() - start));
    }

    public void process() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("开始执行1");
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> customService.queryOne());
        System.out.println("开始执行2");
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> customService.queryTwo());
        //等待子线程任务完成
        CompletableFuture.allOf(future1, future2).join();
        Integer one = future1.get();
        Integer two = future2.get();
        System.out.println(one);
        System.out.println(two);
        System.out.println("总共耗时：" + (System.currentTimeMillis() - start));
    }
}
