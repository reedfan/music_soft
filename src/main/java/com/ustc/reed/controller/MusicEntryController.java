package com.ustc.reed.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/music_entry")
public class MusicEntryController {

   /* private static Logger logger = LoggerFactory.getLogger(MusicEntryController.class);

    @Autowired
    private MusicEntryService musicEntryService;

    @GetMapping("/find_music_entry_by_keywords")
    public MusicEntryVo findEntryByEntryKeywords(@RequestParam(value = "keyWords", required = true,defaultValue = "qinghuaci")String keyWords){
        MusicEntryVo musicEntryVo = new MusicEntryVo();
        MusicEntry musicEntry = musicEntryService.findEntryByEntryKeywords(keyWords);
        if(musicEntry == null){
            return null;
        }
        BeanUtils.copyProperties(musicEntry,musicEntryVo);
        musicEntryVo.setCreateUser("苏日乐格");
        long num = 1;
//        String redisKey = RedisKeyEnum.MUSIC_ENTRY_COUNT+musicEntry.getEntryKeywords();
//        if(RedisUtils.get(redisKey) != null){
//            num = RedisUtils.incr(redisKey,num);
//        }else {
//            RedisUtils.set(redisKey,num);
//        }
        musicEntryVo.setViewCounts(num);
        return musicEntryVo;
    }

    @PostMapping("/add")
    public CommonRet addEntry(MusicEntryBo musicEntryBo){
        logger.info("addMusicEntry{}",musicEntryBo);
        CommonRet commonRet = FieldUtils.isFieldnotEmpty(musicEntryBo);
        if(commonRet.getCode().equals(CommonRet.ERROR)){
            return commonRet;
        }
        MusicEntry musicEntry = musicEntryService.findEntryByEntryKeywords(musicEntryBo.getEntryKeywords());
        if(musicEntry != null){
            commonRet.setCode(CommonRet.ERROR);
            commonRet.setMsg("该词条已存在");
            return commonRet;
        }
        musicEntry = new MusicEntry();
        BeanUtils.copyProperties(musicEntryBo,musicEntry);
        commonRet = musicEntryService.addEntry(musicEntry);
        return commonRet;
    }
*/

}
