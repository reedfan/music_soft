package com.ustc.reed.controller;


import com.ustc.reed.common.CommonRet;
import com.ustc.reed.pojo.TbPrice;
import com.ustc.reed.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PriceController {

    @Autowired
    private PriceService priceService;


    @PostMapping("/admin/add_price")
    public CommonRet addBottomColumn(@RequestParam(value = "period", required = true) Integer period,
                                     @RequestParam(value = "price", required = true) Integer price,
                                     @RequestParam(value = "version", required = true) String version){

        CommonRet commonRet = new CommonRet();
        Integer data = priceService.addPrice(period,price,version);
        commonRet.setData(data);

        return commonRet;

    }

    @GetMapping("/api/price_list")
    public CommonRet getCycleUrlList () {
        CommonRet commonRet = new CommonRet();
        List<TbPrice> priceUrlList = priceService.getPriceList();
        commonRet.setData(priceUrlList);
        return commonRet;
    }
}
