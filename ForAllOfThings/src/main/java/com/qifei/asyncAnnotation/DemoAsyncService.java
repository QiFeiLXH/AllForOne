package com.qifei.asyncAnnotation;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/5 14:50
 * @Description 异步
 */
@Component // 这个类本身要被Spring管理
public class DemoAsyncService {
    @Async  // 添加注解表示这个方法要异步执行
    public void testAsync(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("testAsync invoked");
    }



}
