package com.ustc.reed.controller;


import com.ustc.reed.common.CommonRet;
import com.ustc.reed.pojo.MusicEntry;
import com.ustc.reed.service.MusicEntryService;
import com.ustc.reed.utils.RedisUtils;
import com.ustc.reed.vo.MusicEntryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MusicEntryController {
    @Autowired
    private MusicEntryService musicEntryService;

    @GetMapping("/find_music_entry_by_keywords/keyWords")
    public MusicEntryVo findEntryByEntryKeywords(@RequestParam(value = "keyWords", required = true,defaultValue = "qinghuaci")String keyWords){
        MusicEntryVo musicEntryVo = new MusicEntryVo();
        MusicEntry musicEntry = musicEntryService.findEntryByEntryKeywords(keyWords);
        BeanUtils.copyProperties(musicEntry,musicEntryVo);
        musicEntryVo.setCreateUser("苏日乐格");
        long num = 1;
//        if(RedisUtils.get("") != null){
//            num = RedisUtils.incr("")
//        }
//        RedisUtils.incr("",0);
        musicEntryVo.setViewCounts(num);
        return musicEntryVo;
    }

    @PostMapping("/add")
    public CommonRet addEntry(MusicEntry musicEntry){
        CommonRet commonRet = new CommonRet();
        commonRet = musicEntryService.addEntry(musicEntry);
        return commonRet;
    }


}
