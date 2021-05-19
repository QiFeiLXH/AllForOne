package com.example.redis;

import com.example.redis.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootRedisDemoApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    /*@Test
    public void contextLoads() {
        System.out.println(111111);
        Person p = new Person(1, "Azir");
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("qifei",p);
        Object qifei = ops.get("qifei");
        System.out.println(qifei);
    }*/

    @Test
    public void testObj() throws Exception{
        User user = new User(1, "java架构师技术栈", "man");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("fdd2", user);
        Boolean exists = redisTemplate.hasKey("fdd2");
        log.info("redis是否存在相应的key: " + exists);
        User userTwo = (User)redisTemplate.opsForValue().get("fdd2");
        log.info("从redis数据库获取的User: " + userTwo.toString());
    }

}
