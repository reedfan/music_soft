package com.ustc.reed.controller;


import com.ustc.reed.common.CommonRet;
import com.ustc.reed.pojo.MusicEntry;
import com.ustc.reed.service.MusicEntryService;
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
    public MusicEntry findEntryByEntryKeywords(@RequestParam(value = "keyWords", required = true,defaultValue = "qinghuaci")String keyWords){
        return musicEntryService.findEntryByEntryKeywords(keyWords);
    }

    @PostMapping("/add")
    public CommonRet addEntry(MusicEntry musicEntry){
        CommonRet commonRet = new CommonRet();
        commonRet = musicEntryService.addEntry(musicEntry);
        return commonRet;

    }





}
