package com.ustc.reed.service;

import com.ustc.reed.mapper.BottomColumnMapper;
import com.ustc.reed.pojo.BottomColumnVO;
import com.ustc.reed.pojo.TbBottomColumn;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class BottomColumnService {
    @Autowired
    private BottomColumnMapper bottomColumnMapper;

    public Integer addBottomColumn(Integer cateId, String bottomColumn, String bottomColumnUrl){
        Integer res = bottomColumnMapper.addBottomColumn(cateId,bottomColumn,bottomColumnUrl);
        return res;
    }

    @Cacheable(cacheNames ={"home"} ,key = "'bottomColumnList'")
    public Map<String,List<BottomColumnVO>> bottomColumnList(){

        Map<String,List<BottomColumnVO>> map = new HashMap<>();

        List<TbBottomColumn> bottomColumnList = bottomColumnMapper.findBottomColumnList();

        for (TbBottomColumn bottomColumn:bottomColumnList){
            BottomColumnVO bottomColumnVO = new BottomColumnVO();
            BeanUtils.copyProperties(bottomColumn,bottomColumnVO);
            List<BottomColumnVO> bottomColumnVOList = map.get(bottomColumn.getBottomCate());
            if(!CollectionUtils.isEmpty(bottomColumnVOList)){
                bottomColumnVOList.add(bottomColumnVO);
            }else {
                List<BottomColumnVO> newBottomColumnVOList = new ArrayList<>();
                newBottomColumnVOList.add(bottomColumnVO);
                map.put(bottomColumn.getBottomCate(),newBottomColumnVOList);

            }
        }
        return map;

    }

}
