package com.ustc.reed.pojo;

import lombok.Data;

@Data
public class TbUser {
    private Integer id;

    private String userName;

    private String password;

    private String salt;

    private String headUrl;

}