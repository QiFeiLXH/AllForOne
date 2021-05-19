package org.qifei.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @BelongsProject: AllForOne
 * @BelongsPackage: org.qifei.entity
 * @Author: QiFei
 * @CreateTime: 2020-03-26 16:51
 * @Description:
 */
@Data
@ToString
public class UserInfo {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
}
