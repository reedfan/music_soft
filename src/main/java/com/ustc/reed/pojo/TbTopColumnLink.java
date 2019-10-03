package com.ustc.reed.pojo;

import lombok.Data;

@Data
public class TbTopColumnLink {
    private Integer id;
    private String columnLinkName;
    private String columnLinkUrl;
    private Integer parentId;
    private Integer cId;


}
