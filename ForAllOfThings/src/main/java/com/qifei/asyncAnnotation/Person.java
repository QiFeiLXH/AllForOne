package com.qifei.asyncAnnotation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @Author Xuhui Lin
 * @Date 2021/2/2 16:56
 * @Description
 */
public class Person implements Externalizable {
    private String name;
    private String school;
    private Integer age;
    private Integer score;

    public Person() {
    }

    public Person(String name, String school) {
        this.name = name;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(school);
        out.writeInt(age);
        out.writeInt(score);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        school = (String) in.readObject();
        age = in.readInt();
        score = in.readInt();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
