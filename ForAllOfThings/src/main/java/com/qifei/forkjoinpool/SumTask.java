package com.qifei.forkjoinpool;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/25 15:45
 * @Description
 */

import java.util.concurrent.RecursiveTask;

/**
 * 统计总数的任务
 */
class SumTask extends RecursiveTask<Integer> {

    /**
     * 每个小任务 最多只累加5个数
     */
    private static final int THRESHOLD = 5;
    /**
     * 数据的数组
     */
    private int arry[];
    private int start;
    private int end;

    public SumTask(int[] arry, int start, int end) {
        super();
        this.arry = arry;
        this.start = start;
        this.end = end;
    }

    /**
     * 类种是什么类型的值就返回什么类型的值
     * @return
     */
    @Override
    protected Integer compute() {
        int sum =0;
        /**
         * 当end与start之间的差小于设定任务数量时，才开始进行实际的累加
         */
        if(end - start <THRESHOLD){
            for(int i= start;i<end;i++){
                sum += arry[i];
            }
            return sum;
        }else {
            /**
             * 任务数量超过规定执行数量时 , 进行二分法拆分
             */
            int middle = (start+ end)/2;
            SumTask small = new SumTask(arry, start, middle);
            SumTask big = new SumTask(arry, middle, end);
            /**
             * 执行任务 small.fork(); big.fork();
             */
            invokeAll(small, big);

            /**
             * 把各个小任务累加的结果合并起来并且返回
             * join() 会等待子任务执行完并得到其结果
             */
            return small.join()+big.join();
        }
    }
}
