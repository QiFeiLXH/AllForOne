package com.qifei.mapstruct;

import lombok.Data;
import lombok.ToString;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/13 16:17
 * @Description
 */
@Data
@ToString
public class UserDO {
    private String userName;
    private Integer age;
    private Integer hasChild;


}
