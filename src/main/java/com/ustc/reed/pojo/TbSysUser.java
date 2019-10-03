package com.ustc.reed.pojo;

import lombok.Data;

@Data
public class TbSysUser {
    private Integer id;
    private String userName;
    private String passWord;
    private String phoneNumber;
}