package org.qifei.threadLocal;

/**
 * @Author Xuhui Lin
 * @Date 2020/6/23 15:26
 * @Description
 */
public class Student extends Person {
    final public static String DEFAULT_NAME="Lisa";

    public Student() {
        super(DEFAULT_NAME);
    }

    public static void main(String[] args) {
        Person p = new Student();
        System.out.println(p);
    }
}
