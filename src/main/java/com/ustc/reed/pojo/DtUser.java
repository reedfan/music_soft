package com.ustc.reed.pojo;

import lombok.Data;

@Data
public class DtUser {

    private int uId;
    private String account;
    private String password;
    private String avatar;
    private String nick;
    private String gender;
    private int birthday;
    private String mobile;
    private double money;
    private double moneyCount;
    private int number;
    private int refer;
    private String recode;
    private int status;
    private int createTime;
    private int flag;
}
