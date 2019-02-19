package com.ustc.reed.pojo;

import java.util.Date;

/**
 * created by reedfan on 2019/1/6
 */
public class User {
    private String id;

    private String username;

    private String password;

    private Date birthday;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return id+"id"+username+"userName"+password+"password"+birthday+"birthday";
    }
}
