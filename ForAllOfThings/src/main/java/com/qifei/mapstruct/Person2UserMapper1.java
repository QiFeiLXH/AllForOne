package com.qifei.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/13 16:32
 * @Description
 */
@Mapper(imports = {Person2UserUtils.class}, componentModel = "spring")
public interface Person2UserMapper1 {
    Person2UserMapper1 INSTANCE = Mappers.getMapper(Person2UserMapper1.class);
//    @MapMapping
    @Mapping(source = "userName", target = "name")
    @Mapping(target = "hasChild", expression = "java(new Person2UserUtils().convertInt2Bool(userDO.getHasChild()))")
    PersonDO user2Person(UserDO userDO);


}
