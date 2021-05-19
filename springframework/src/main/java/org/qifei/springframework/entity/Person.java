package org.qifei.springframework.entity;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/2 14:09
 * @Description
 */
public class Person {
    private String age;
    private Pet pet;

    public Person() {
        System.out.println("new Person");
    }

    public Person(String age, Pet pet) {
        this.age = age;
        this.pet = pet;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
