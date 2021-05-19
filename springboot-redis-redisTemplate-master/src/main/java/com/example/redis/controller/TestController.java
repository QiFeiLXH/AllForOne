package com.example.redis.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @Author liuzongqiang
 * @Date 2019/7/25 0025 15:54
 * @Version 1.0
 **/
@RestController
public class TestController {
    /*@Autowired
    RedisUtil redisUtil;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;// 通过构造方法注入该对象

    @GetMapping("/getdata")
    public Object getdata(){
        //测试redis

        redisUtil.set("name","小猫");
        System.out.println(redisUtil.getExpire("name"));
        return redisUtil.get("name");

    }*/
}
