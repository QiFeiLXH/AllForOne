package org.qifei.springframework.entity;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/2 14:09
 * @Description
 */
public class Pet {
    private String petName;

    public Pet() {
        System.out.println("初始化Pet");
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }
}
