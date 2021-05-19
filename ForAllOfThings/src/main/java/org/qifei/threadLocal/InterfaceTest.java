package org.qifei.threadLocal;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/13 15:57
 * @Description
 */
public interface InterfaceTest {
    void test();
    default String test1() {
        return null;
    }
    default void test2() {

    }
}
