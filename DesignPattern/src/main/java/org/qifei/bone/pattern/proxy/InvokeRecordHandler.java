package org.qifei.bone.pattern.proxy;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/22 17:06
 * @Description
 */
@Component
public class InvokeRecordHandler extends BaseMethodAdviceHandler<Object> {
    /**
     * 记录方法出入参和调用时长
     */
    @Override
    public void onComplete(ProceedingJoinPoint point, long startTime, boolean permitted, boolean thrown, Object result) {
        String methodDesc = getMethodDesc(point);
        Object[] args = point.getArgs();
        long costTime = System.currentTimeMillis() - startTime;

    }

    @Override
    protected String getMethodDesc(ProceedingJoinPoint point) {
        Method targetMethod = getTargetMethod(point);
        // 获得方法上的 InvokeRecordAnno
        InvokeRecordAnno anno = targetMethod.getAnnotation(InvokeRecordAnno.class);
        String description = anno.value();

        // 如果没有指定方法说明，那么使用默认的方法说明
        if (StringUtils.isBlank(description)) {
            description = super.getMethodDesc(point);
        }

        return description;
    }
}
