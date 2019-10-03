package com.ustc.reed.controller;

import com.ustc.reed.common.CommonRet;
import com.ustc.reed.mapper.ColumnLinkMapper;
import com.ustc.reed.pojo.BottomColumnVO;
import com.ustc.reed.pojo.TbBottomColumn;
import com.ustc.reed.pojo.TbColumnLink;
import com.ustc.reed.pojo.TbColumnStr;
import com.ustc.reed.service.BottomColumnService;
import com.ustc.reed.service.ColumnLinkService;
import com.ustc.reed.service.ColumnStrService;
import com.ustc.reed.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BottomController {
    @Autowired
    private BottomColumnService bottomColumnService;

    @Autowired
    private ColumnLinkService columnLinkService;

    @Autowired
    private ColumnStrService columnStrService;


    @PostMapping("/admin/add_bottom_column")
    public CommonRet addBottomColumn(
            @RequestParam(value = "cate_id", required = true) Integer cateId,
            @RequestParam(value = "bottom_column", required = true) String bottomColumn,
            @RequestParam(value = "bottom_column_url", required = true) String bottomColumnUrl) {
        CommonRet commonRet = new CommonRet();
        Integer data = bottomColumnService.addBottomColumn(cateId, bottomColumn, bottomColumnUrl);
        commonRet.setData(data);
        return commonRet;

    }

    @GetMapping("/api/bottom_column_list")
    public CommonRet getbottomColumnList() {
        CommonRet commonRet = new CommonRet();
        Map<String, Object> resMap = new HashMap<>();
        Map<String, List<BottomColumnVO>> map = bottomColumnService.bottomColumnList();
        List<TbColumnLink> bottomLinkList = columnLinkService.findColumnLinkList();
        List<TbColumnStr> bottomStrList = columnStrService.findColumnLinkList();
        resMap.put("bottomColumnMap", map);
        resMap.put("columnLink", bottomLinkList);
        resMap.put("bottomStr", bottomStrList);
        resMap.put("bottomDescription","© 2008-2019 南通企智网络工程有限公司 版权所有   苏ICP备08016937号   腾云网是南通企智网络工程有限公司旗下建站品牌  地址：江苏省南通市工农路488号软件园A座1F   \n" +
                "    网站地图   站长统计  售前咨询：4008-400-301  售后服务：4008-868-220 ");
        commonRet.setData(resMap);
        return commonRet;
    }


}
