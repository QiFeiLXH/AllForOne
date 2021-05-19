package org.qifei.springframework.beans;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/29 11:15
 * @Description
 */
public class QifeiTestBean {
    private String name;
    {
        this.name = "超级无敌大帅哥";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
