package org.qifei.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.qifei.redis.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/8 14:32
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= SpringBootRedisApplication.class)
@Slf4j
public class SpringBootRedisApplicationTest {
    @Autowired
    private RedisTemplate redisTemplate;

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
