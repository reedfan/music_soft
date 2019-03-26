package com.ustc.reed.service;

import com.ustc.reed.common.CommonRet;
import com.ustc.reed.pojo.MusicEntry;

public interface MusicEntryService {
    MusicEntry findEntryByEntryKeywords(String keyWords);
    CommonRet addEntry(MusicEntry musicEntry);
}
