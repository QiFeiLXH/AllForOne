package org.qifei.streamapi;


import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/10 16:16
 * @Description
 */
public class MapTest {
    @Test
    public void computeIfAbsent() {
        Map<String, List<String>> map = new HashMap<>();
        map.computeIfAbsent("qifei",k -> new ArrayList<>()).add("大个子");
        System.out.println(map);
    }

    @Test
    public void getOrDefault() {
        Map<String, List<String>> map = new HashMap<>();

        List<String> list = map.getOrDefault("qifei", new ArrayList<String>() {
            {
                add("你是谁");
            };
        });
        System.out.println(list);
    }

    @Test
    public void computeIfPresent() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("qifei",new ArrayList<String>() {
            {
                add("你是谁");
            };
        });
        map.computeIfPresent("qifei", (x, y) -> Arrays.asList("你猜啊")); // {qifei=[你猜啊]}
        //map.computeIfPresent("qifei", (x, y) -> null); // {}
        System.out.println(map);
    }

    @Test
    public void putIfAbsent () {
        Map<String, List<String>> map = new HashMap<>();
        map.putIfAbsent("qifei",Arrays.asList("大个子"));
        System.out.println(map);
    }
}
