package org.qifei.algorithm;

import org.junit.jupiter.api.Test;
import org.qifei.entity.Person;
import org.qifei.entity.Student;
import org.qifei.entity.Teacher;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/18 16:14
 * @Description 设一组N个数，确定其中第K个最大值
 */
public class CalculateKMaxValue {
    @Test // 冒泡排序
    public void test1() {
        int n = 100;
        int k = 35;
        int[] ints = new Random().ints(1, 200).distinct().limit(n).toArray();
        for (int i = 0; i < ints.length; i++) {
            for (int j = i; j < ints.length; j++) {
                int temp = ints[i];
                if (ints[i] > ints[j]) {
                    ints[i] = ints[j];
                    ints[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(ints));
        System.out.println(ints[k-1]);
    }

    @Test // 将前k个数放入一个数组排序，然后将后面的数与前者数组比较
    public void test2() {
        int n = 100;
        int k = 35;
        int[] ints = new Random().ints(1, 200).distinct().limit(n).toArray();
        int[] ints1 = Arrays.copyOf(ints, k);
        for (int i = 0; i < ints1.length; i++) {
            for (int j = i; j < ints1.length; j++) {
                int temp = ints1[i];
                if (ints1[i] > ints1[j]) {
                    ints1[i] = ints1[j];
                    ints1[j] = temp;
                }
            }
        }
    }

    @Test
    public void test3() {
        // 数组协变
        Person[] persons = new Teacher[6];
        System.out.println(persons[0]);
        persons[0] = new Teacher();
        System.out.println(persons[0]);
        // 问题：将不能编译检查类型   java.lang.ArrayStoreException
        persons[1] = new Student();
        System.out.println(persons[1]);
    }

    @Test
    public void test4() {
        // 相对增长率

    }


}
