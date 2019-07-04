package com.cskaoyan.controller.generalize;

import com.cskaoyan.bean.Coupon;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.generalize.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/4 14:07
 **/
@Controller
@RequestMapping("admin")
public class CouponController {

    @Autowired
    CouponService couponService;

    @RequestMapping("coupon/list")
    @ResponseBody
    public ResponseVO<Map<String, Object>> couponList(String name,Short type,Short status, int page,int limit,String sort,String order){
        ResponseVO<Map<String, Object>> mapResponseVO = new ResponseVO<>();
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setErrno(0);
        List<Coupon> couponList = couponService.findCouponList(name,type,status);
        int total = couponList.size();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("items", couponList);
        mapResponseVO.setData(map);
        return mapResponseVO;
    }
}
