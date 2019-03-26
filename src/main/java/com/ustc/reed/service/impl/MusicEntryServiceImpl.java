package com.ustc.reed.service.impl;

import com.ustc.reed.common.CommonRet;
import com.ustc.reed.mapper.MusicEntryMapper;
import com.ustc.reed.pojo.MusicEntry;
import com.ustc.reed.service.MusicEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MusicEntryServiceImpl implements MusicEntryService {
    @Autowired
    private MusicEntryMapper musicEntryMapper;

    @Override
    public MusicEntry findEntryByEntryKeywords(String keyWords) {
        MusicEntry musicEntry = musicEntryMapper.findEntryByEntryKeywords(keyWords);
        return musicEntry;
    }

    @Override
    public CommonRet addEntry(MusicEntry musicEntry) {
        CommonRet commonRet = new CommonRet();

        Date date = new Date();
        musicEntry.setCreateTime(date);
        musicEntry.setUpdateTime(date);


        try {
            musicEntryMapper.addEntry(musicEntry);
        } catch (Exception e){
            commonRet.setCode(CommonRet.ERROR);
            commonRet.setMsg("该词条已存在，插入失败");

        }

        return commonRet;

    }
}
