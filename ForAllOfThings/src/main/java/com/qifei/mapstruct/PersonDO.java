package com.qifei.mapstruct;

import lombok.Data;
import lombok.ToString;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/13 16:30
 * @Description
 */
@Data
@ToString
public class PersonDO {
    private String name;
    private Integer age;
    private Boolean hasChild;
}
