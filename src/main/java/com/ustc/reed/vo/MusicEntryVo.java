package com.ustc.reed.vo;

import com.ustc.reed.pojo.MusicEntry;
import lombok.Data;

import java.util.Date;

@Data
public class MusicEntryVo {
    private Long viewCounts;
    private Long id;
    private String entryKeywords;
    private String officialExplain;
    private String oralExplain;
    private String createUser;
    private Date createTime;
    private Date updateTime;
}
