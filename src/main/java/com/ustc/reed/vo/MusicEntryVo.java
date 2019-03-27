package com.ustc.reed.vo;

import com.ustc.reed.pojo.MusicEntry;
import lombok.Data;

@Data
public class MusicEntryVo {
    private Long viewCount;
    private MusicEntry musicEntry;

}
