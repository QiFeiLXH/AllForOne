package org.qifei.apitoken.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/6/23 13:51
 * @Description
 */
@Data
@AllArgsConstructor
public class AccessToken {
    /** token */
    private String token;

    /** 失效时间 */
    private Date expireTime;
}
