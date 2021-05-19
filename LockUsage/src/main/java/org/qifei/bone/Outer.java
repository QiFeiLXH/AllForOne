package org.qifei.bone;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/12 15:03
 * @Description
 */
public class Outer {
    private static Integer a;
    static class Inner {
        void test () {
            System.out.println(a);
        }
    }
}
