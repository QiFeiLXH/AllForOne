package org.qifei.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ExecutionException;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/28 15:15
 * @Description
 */
public class Testfuture {
    @Test //2008
    public void test1 () {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
        CompleteFuture completeFuture = context.getBean(CompleteFuture.class);
        completeFuture.execute();
    }

    @Test //1018
    public void test2 () throws ExecutionException, InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
        CompleteFuture completeFuture = context.getBean(CompleteFuture.class);
        completeFuture.process();
    }
}
