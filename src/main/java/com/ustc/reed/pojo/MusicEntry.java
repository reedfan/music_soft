package com.ustc.reed.pojo;

import lombok.Data;
import java.util.Date;

@Data
public class MusicEntry {
    private Long id;
    private String entryKeywords;
    private String officialExplain;
    private String oralExplain;
    private Long createUserId;
    private Date createTime;
    private Date updateTime;
}
