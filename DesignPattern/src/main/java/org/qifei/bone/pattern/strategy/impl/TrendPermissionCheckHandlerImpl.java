package org.qifei.bone.pattern.strategy.impl;

import org.qifei.bone.pattern.constant.BizType;
import org.qifei.bone.pattern.strategy.PermissionCheckHandler;
import org.springframework.stereotype.Service;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/26 17:38
 * @Description
 */
@Service
public class TrendPermissionCheckHandlerImpl implements PermissionCheckHandler {
    @Override
    public boolean isMatched(BizType bizType) {
        return BizType.TREND.equals(bizType);
    }
    @Override
    public Integer permissionCheck(Long userId, String bizCode){
        //业务特有鉴权逻辑
        return null;
    }
}
