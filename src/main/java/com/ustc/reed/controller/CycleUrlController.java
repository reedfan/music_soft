package com.ustc.reed.controller;

import com.ustc.reed.common.CommonRet;
import com.ustc.reed.exception.InternalException;
import com.ustc.reed.pojo.BottomColumnVO;
import com.ustc.reed.service.BottomColumnService;
import com.ustc.reed.service.CycleUrlService;
import com.ustc.reed.utils.FileNameUtils;
import com.ustc.reed.utils.FileUtils;
import com.ustc.reed.utils.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

@RestController
public class CycleUrlController {
    @Autowired
    private CycleUrlService cycleUrlService;

    @Value("${upload-path}")
    private String path;

    @Value("${local-ip}")
    private String ip;


    @PostMapping("/admin/add_cycle_url")
    public CommonRet addBottomColumn(@RequestParam("fileName") MultipartFile file) throws UnknownHostException {
        //获取本机的ip地址和域名

        CommonRet commonRet = null;
        Integer data = null;
        try {

            String originalFileName = file.getOriginalFilename();
            String newFileName = FileNameUtils.getFileName(originalFileName);
            commonRet = new CommonRet();

            FileUtils.upload(file,path,newFileName);

            data = cycleUrlService.addCycleUrl(ip+"/image/"+newFileName);
        } catch (Exception e) {
            throw new InternalException("上传轮播照片失败");
        }
        commonRet.setData(data);
        return commonRet;
    }

    @PutMapping(value = "/admin/update_cycle_url", produces = "application/json")
    public CommonRet updateBottomColumn(@RequestParam(value = "cycle_url", required = true)  String cycleUrl,

                                        @RequestParam(value = "id", required = true)Integer id){
        CommonRet commonRet = new CommonRet();
        Integer data = cycleUrlService.updateCycleUrl(cycleUrl,id);
        commonRet.setData(data);
        return commonRet;
    }

    @DeleteMapping("/admin/delete_cycle_url")
    public CommonRet deleteCycleUrlById(@RequestParam(value = "cycle_url", required = true)  String cycleUrl,
                                        @RequestParam(value = "id", required = true) Integer id){
        CommonRet commonRet = new CommonRet();

        Boolean data = cycleUrlService.deleteCycleUrlById(id,cycleUrl);
        commonRet.setData(data);
        return commonRet;

    }

    @GetMapping("/api/cycle_url_list")
    public CommonRet getCycleUrlList () {
        CommonRet commonRet = new CommonRet();
        List<String> cycleUrlList = cycleUrlService.getCycleUrlList();

        commonRet.setData(cycleUrlList);
        return commonRet;
    }






}
