package org.qifei.bone.pattern.strategy.impl;

import org.qifei.bone.pattern.constant.BizType;
import org.qifei.bone.pattern.strategy.PermissionCheckHandler;
import org.qifei.bone.pattern.strategy.PermissionService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/26 17:25
 * @Description
 */
@Service
public class PermissionServiceImpl implements PermissionService, ApplicationContextAware, InitializingBean {
    private ApplicationContext applicationContext;
    //注：这里可以使用Map，偷个懒
    private List<PermissionCheckHandler> handlers = new ArrayList<>();

    @Override
    public Integer permissionCheck(BizType bizType, Long userId,
                                   String bizCode) {
        //省略一些前置逻辑
        PermissionCheckHandler handler = getHandler(bizType);
        return handler.permissionCheck(userId, bizCode);
    }

    private PermissionCheckHandler getHandler(BizType bizType) {
        for (PermissionCheckHandler handler : handlers) {
            if (handler.isMatched(bizType)) {
                return handler;
            }
        }
        return null ;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(1111);
        Map<String, PermissionCheckHandler> beansOfType = applicationContext.getBeansOfType(PermissionCheckHandler.class);

        for (PermissionCheckHandler handler : applicationContext.getBeansOfType(PermissionCheckHandler.class)
                .values()) {
            handlers.add(handler);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(2222);
        this.applicationContext = applicationContext;
    }
}
