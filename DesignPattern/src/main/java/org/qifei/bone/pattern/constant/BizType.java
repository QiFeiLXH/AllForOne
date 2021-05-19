package org.qifei.bone.pattern.constant;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/26 17:27
 * @Description
 */
public enum BizType {
    TREND(1),
    COLD_START(2);
    private Integer bizCode;

    BizType() {
    }

    BizType(Integer bizCode) {
        this.bizCode = bizCode;
    }

    public Integer getBizCode() {
        return bizCode;
    }

    public void setBizCode(Integer bizCode) {
        this.bizCode = bizCode;
    }
}
