package com.qifei.mapstruct;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/14 10:42
 * @Description
 */
public class Person2UserUtils {
    Boolean convertInt2Bool(Integer val) {
        if (val == 1) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}
