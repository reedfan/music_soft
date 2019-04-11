package com.ustc.reed.service.impl;

import com.ustc.reed.common.CommonRet;
import com.ustc.reed.mapper.MusicEntryMapper;
import com.ustc.reed.pojo.MusicEntry;
import com.ustc.reed.service.MusicEntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MusicEntryServiceImpl implements MusicEntryService {
    private static Logger logger = LoggerFactory.getLogger(MusicEntryServiceImpl.class);
    @Autowired
    private MusicEntryMapper musicEntryMapper;

    @Override
    public MusicEntry findEntryByEntryKeywords(String keyWords) {
        MusicEntry musicEntry = musicEntryMapper.findEntryByEntryKeywords(keyWords);
        return musicEntry;
    }

    @Override
    public CommonRet addEntry(MusicEntry musicEntry) {
        Date date = new Date();
        musicEntry.setCreateTime(date);
        musicEntry.setUpdateTime(date);
        logger.info(" MusicEntryService add musicEntry {}",musicEntry);
        CommonRet commonRet = new CommonRet();
        try {
            musicEntryMapper.addEntry(musicEntry);
        } catch (Exception e){
            logger.error("add musicEntry error",e);
            commonRet.setCode(CommonRet.ERROR);
            commonRet.setMsg("服务器内部错误，插入失败");
        }
        return commonRet;
    }
}
