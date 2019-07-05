package com.cskaoyan.controller;

import com.cskaoyan.service.MallRegionService;
import com.cskaoyan.bean.Region;
import com.cskaoyan.responseVo.ResponseVO1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("admin")
public class MallRegionController {
    @Autowired
    MallRegionService mallRegionService;

    @RequestMapping("region/list")
    @ResponseBody
    public ResponseVO1<List<Region>> showArea(){

        List<Region> regions = mallRegionService.showArea();
        ResponseVO1<List<Region>> responseVO1 = new ResponseVO1<>();
        responseVO1.setData(regions);
        responseVO1.setErrmsg("成功");
        responseVO1.setErrno(0);
        System.out.println(regions);
        return responseVO1;
    }
}
