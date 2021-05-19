package com.qifei.forkjoinpool;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/25 15:44
 * @Description
 */

import java.util.concurrent.RecursiveAction;

/**
 * 继承 RecursiveAction 来实现任务可分解
 */
class PrintTasks extends RecursiveAction {

    private static final int THRESHOLD = 20; // 设置一个最多打印的数
    private int start;
    private int end;

    public PrintTasks(int start, int end) {
        super();
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        /**
         * 进行小任务划分
         */
        if (end - start < THRESHOLD) {
            for(int i=start; i<end ; i++){
                System.out.println(Thread.currentThread().getName()+"的i ： "+i);
            }
        } else {
            /**
             * 二分法, 直到任务的规模小于规定的规模为止
             */
            int middle =(start+end)/2;
            PrintTasks left = new PrintTasks(start, middle);
            PrintTasks right = new PrintTasks(middle, end);
            /**
             * fork() 就是执行的意思left.fork();right.fork();
             * 这里并行执行以下
             */
            invokeAll(left, right);

        }
    }
}