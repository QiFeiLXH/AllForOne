package org.qifei.streamapi;

import java.util.function.Predicate;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/10 13:46
 * @Description Predicate 函数
 */
public class PredicateTest {
    public static void main(String[] args) {
        int a = 6;
        int b = 2;
        boolean val = getBoolValue(a,b);
        System.out.println(val);
    }

    private static boolean getBoolValue(int x, int y) {
        Predicate<Integer> atLeast5 = z -> z > y;
        return atLeast5.test(x);
    }

}
