package org.qifei.apitoken.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Xuhui Lin
 * @Date 2020/6/23 13:51
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppInfo {
    /** App id */
    private String appId;
    /** API 秘钥 */
    private String key;
}
