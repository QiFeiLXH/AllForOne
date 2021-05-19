package com.qifei.stream.parallelStream;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/29 9:11
 * @Description
 */
public class ParallelStreamTest {

    @Test
    public void test1 () {
        List list = new ArrayList<>();
        for(int i = 0;i<1000;i++){
            list.add(i);
        }
        System.out.println(list.size());
    }

    @Test
    public void test2() {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<1000000;i++){
            list.add(i);
        }
        System.out.println("list的size大小：" + list.size());
        long startTime = System.currentTimeMillis();
        List<Integer> parallelList = new ArrayList();
        list.stream().forEach(item -> {
            parallelList.add(item);
        });
        System.out.println("parallelList的size大小： " + parallelList.size() + " 共耗时： " + (System.currentTimeMillis() - startTime)); // parallelList的size大小： 10000 共耗时： 4
    }

    @Test
    public void test3() {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<1000000;i++){
            list.add(i);
        }
        System.out.println("list的size大小：" + list.size());
        long startTime = System.currentTimeMillis();
        List<Integer> parallelList = new ArrayList();
        list.parallelStream().forEach(item -> {
            parallelList.add(item);
        });
        System.out.println("parallelList的size大小： " + parallelList.size() + " 共耗时： " + (System.currentTimeMillis() - startTime));
    }

}
