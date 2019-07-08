package com.cskaoyan.controller;

import com.cskaoyan.bean.HomeData;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.mapper.mallManege.MallHomeMapper;
import com.cskaoyan.service.MallBrandService;
import com.cskaoyan.service.MallCategoryService;
import com.cskaoyan.service.generalize.AdService;
import com.cskaoyan.service.generalize.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class MallHomeController {

    @Autowired(required = false)
    MallHomeMapper mallHomeMapper;

    @Autowired
    AdService adService;

    @Autowired
    MallBrandService brandService;

    @Autowired
    MallCategoryService categoryService;

    @Autowired
    CouponService couponService;

    @RequestMapping("admin/dashboard")
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

    //微信首页
    @RequestMapping("wx/home/index")
    @ResponseBody
    public ResponseVO<Map> index() {
        ResponseVO<Map> responseVO = new ResponseVO<>();
        Map<String, Object> map = new LinkedHashMap<>();

        //广告
        map.put("banner",adService.queryAds());

        //品牌
        map.put("brandList",brandService.queryBrands());

        //一级类目
        map.put("channel",categoryService.queryKindCategories());

        //优惠券
        map.put("couponList",couponService.queryCoupons());

        //
        map.put("floorGoodsList",null);

        //团购
        map.put("grouponList",null);

        //
        map.put("hotGoodsList",null);
        map.put("new GoodsList",null);
        map.put("topicList",null);

        responseVO.setData(map);
        responseVO.setErrno(0);
        responseVO.setErrmsg("成功");
        return responseVO;
    }
}
