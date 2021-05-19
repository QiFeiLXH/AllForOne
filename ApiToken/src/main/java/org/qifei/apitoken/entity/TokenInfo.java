package org.qifei.apitoken.entity;

import lombok.Data;

/**
 * @Author Xuhui Lin
 * @Date 2020/6/23 13:51
 * @Description
 */
@Data
public class TokenInfo {
    /** token类型: api:0 、user:1 */
    private Integer tokenType;

    /** App 信息 */
    private AppInfo appInfo;

    /** 用户其他数据 */
    private UserInfo userInfo;
}
