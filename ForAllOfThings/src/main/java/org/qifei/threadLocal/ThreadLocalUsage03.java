package org.qifei.threadLocal;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @Author Xuhui Lin
 * @Date 2020/6/22 16:09
 * @Description
 */
public class ThreadLocalUsage03 {
    public static void main(String[] args) {
        Set<String> collected = Stream.of("a", "b", "c").collect(toSet());
        assertNotEquals(Arrays.asList("a", "b", "d"), collected);
    }
}
