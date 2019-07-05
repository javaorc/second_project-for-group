package com.cskaoyan.controller;

import com.cskaoyan.bean.HomeData;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.mapper.mallManege.MallHomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class MallHomeController {
    @Autowired(required = false)
    MallHomeMapper mallHomeMapper;
    @RequestMapping("dashboard")
    @ResponseBody
    public ResponseVO<Map<String,Object>> showHome(){
        HomeData homeData = mallHomeMapper.showHome();
        Map<String, Object> map = new HashMap<>();
        map.put("goodsTotal",homeData.getGoodsNum());
        map.put("orderTotal",homeData.getOrderNum());
        map.put("productTotal",homeData.getProductNum());
        map.put("userTotal",homeData.getUserNum());
        ResponseVO<Map<String, Object>> responseVO = new ResponseVO<>();
        responseVO.setData(map);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }
}
