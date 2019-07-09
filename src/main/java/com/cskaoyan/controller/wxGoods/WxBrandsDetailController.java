package com.cskaoyan.controller.wxGoods;


import com.cskaoyan.bean.Brand;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.wxGoods.WxBrandsDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WxBrandsDetailController {

    @Autowired
    WxBrandsDetailServiceImpl brandsDetailService;

    @RequestMapping("wx/brand/detail")
    @ResponseBody
    public ResponseVO<Map> queryBrandDetail(Integer id){

        ResponseVO<Map> mapResponseVO = new ResponseVO<>();
        Map<Object, Object> map = new HashMap<>();
        Brand brand = brandsDetailService.queryBrandsDetailById(id);
        map.put("brand",brand);
        mapResponseVO.setData(map);
        mapResponseVO.setErrno(0);
        mapResponseVO.setErrmsg("成功");
        return mapResponseVO;

    }
}
