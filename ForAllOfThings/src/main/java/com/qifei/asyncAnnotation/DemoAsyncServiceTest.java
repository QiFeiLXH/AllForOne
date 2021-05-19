package com.qifei.asyncAnnotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.Future;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/5 14:52
 * @Description
 */
public class DemoAsyncServiceTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ConfigClass.class);
        /*DemoAsyncService bean = ac.getBean(DemoAsyncService.class);
        bean.testAsync();
        System.out.println("main函数执行完成");*/

        AsyncTask bean = ac.getBean(AsyncTask.class);

        try {
            long start = System.currentTimeMillis();
            Future<String> task1 = bean.task1();
            System.out.println(task1.get());

            Future<String> task2 = bean.task2();
            Future<String> task3 = bean.task3();
            while (true) {
                if (task1.isDone() && task2.isDone() && task3.isDone()) {
                    long total = System.currentTimeMillis() - start;
                    System.out.println("所有task异步执行耗时： " + total);
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
