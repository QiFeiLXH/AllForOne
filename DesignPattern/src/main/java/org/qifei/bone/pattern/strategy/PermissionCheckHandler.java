package org.qifei.bone.pattern.strategy;

import org.qifei.bone.pattern.constant.BizType;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/26 17:26
 * @Description
 */
public interface PermissionCheckHandler {
    /**
     * 判断是否是自己能够处理的权限校验类型
     */
    boolean isMatched(BizType bizType);
    /**
     * 权限校验逻辑
     */
    Integer permissionCheck(Long userId, String bizCode);
}
