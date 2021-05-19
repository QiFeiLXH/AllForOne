package org.qifei.bone.pattern.strategy;

import org.qifei.bone.pattern.constant.BizType;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/26 17:25
 * @Description
 */
public interface PermissionService {
    Integer permissionCheck(BizType bizType, Long userId,String bizCode);
}
