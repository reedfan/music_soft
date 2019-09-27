package com.ustc.reed.pojo;

import lombok.Data;

/**
 * 任务分类
 */
@Data
public class DtCate {
    private int cId;
    private String cateName;
    private String info;
    private String picture;
    private int status;
    private int createTime;
}
