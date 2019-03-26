package com.ustc.reed.mapper;

import com.ustc.reed.pojo.Dept;
import com.ustc.reed.pojo.MusicEntry;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
@Mapper

public interface MusicEntryMapper {
    MusicEntry findEntryByEntryKeywords(String keyWords);
    int addEntry(MusicEntry musicEntry);
}
