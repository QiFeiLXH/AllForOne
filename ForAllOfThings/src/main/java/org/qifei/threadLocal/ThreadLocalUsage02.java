package org.qifei.threadLocal;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Xuhui Lin
 * @Date 2020/6/22 15:59
 * @Description
 */
public class ThreadLocalUsage02 {
    public static ExecutorService THREAD_POOL = Executors.newFixedThreadPool(10);
    static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 线程不安全
    static DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // 线程安全

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            final int finalI = i;
            THREAD_POOL.submit(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalUsage02().date(finalI);
                    System.out.println(date);
                }
            });
        }
        // 关闭线程池，此种关闭方式不再接受新的任务提交，等待现有队列中的任务全部执行完毕之后关闭
        THREAD_POOL.shutdown();
    }

    private String date(int seconds) {
        // 参数的单位是毫秒，从1970.1.1 00:00:00 GMT计时
        Date date = new Date(1000 * seconds);
        return DATE_FORMAT.format(date);
    }
}
