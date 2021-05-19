package com.qifei.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/14 9:33
 * @Description
 */
@Mapper
public interface ItemConverter {
    ItemConverter INSTANCE = Mappers.getMapper(ItemConverter.class);

}
