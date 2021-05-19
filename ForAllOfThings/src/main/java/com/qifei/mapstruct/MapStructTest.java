package com.qifei.mapstruct;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/13 16:48
 * @Description
 */
public class MapStructTest {

    @Test
    public void test1 () {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(StartConfigClass.class);
        Person2UserMapper convert = ac.getBean(Person2UserMapper.class);
        UserDO userDO = new UserDO();
        userDO.setAge(12);
        userDO.setUserName("飞飞");
        userDO.setHasChild(1);
        PersonDO personDO = convert.user2Person(userDO);
        System.out.println(personDO.toString());
//        Person2UserMapper

    }
}
