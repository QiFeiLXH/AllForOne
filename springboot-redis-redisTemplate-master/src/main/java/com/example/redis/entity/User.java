package com.example.redis.entity;

import java.io.Serializable;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/8 14:28
 * @Description
 */
public class User implements Serializable {
    private Integer id;
    private String userName;
    private String userSex;
    public User() {}
    public User(Integer id, String userName, String userSex){
        this.id = id;
        this.userName = userName;
        this.userSex = userSex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                '}';
    }
}
