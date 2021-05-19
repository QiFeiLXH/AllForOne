package org.qifei.bone.usage;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/9 9:39
 * @Description 可缓存的线程池-无核心线程数，最大线程数（2^31 - 1）,过期60s
 */
public class NewCachedThreadPool {
    public static void main(String[] args) {
        for (int i = 0;i < 10;i++) {
            final int a = i;
            System.out.println(a);
        }
    }
}
