package com.cskaoyan.controller;


import com.cskaoyan.service.MallRegionService;
import com.cskaoyan.bean.Region;

import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.MallRegionService;
import com.cskaoyan.bean.Province;
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
    public ResponseVO<List<Province>> showArea(){

        List<Province> provinces = mallRegionService.showArea();
        ResponseVO<List<Province>> responseVO = new ResponseVO<>();
        responseVO.setData(provinces);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }
}
