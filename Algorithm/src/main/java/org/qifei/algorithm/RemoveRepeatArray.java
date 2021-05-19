package org.qifei.algorithm;

import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/8 14:02
 * @Description
 */
public class RemoveRepeatArray {
    // 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度
    // 给定 nums = [3,2,2,3], val = 3,
    //函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
    @Test
    private void test1() {
        int[] nums = {1,2,3,3,4,5,3,6};
        int val = 3;
        for (int i = 0; i < nums.length; i++) {
            if (val == nums[i]){

            }
        }

        BinaryOperator<Long> a = (x,y) -> x + y;
    }
}
