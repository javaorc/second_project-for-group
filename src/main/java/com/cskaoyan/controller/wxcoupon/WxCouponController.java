package com.cskaoyan.controller.wxcoupon;

import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.wxcoupon.WxCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/8 15:13
 **/
@Controller
@RequestMapping("wx")
public class WxCouponController {

    @Autowired
    WxCouponService couponService;

    ResponseVO<Map<String,Object>> mapResponseVO = new ResponseVO<>();

    @RequestMapping("coupon/list")
    @ResponseBody
    public ResponseVO<Map<String,Object>> couponList(int page, int size){
       return couponService.couponList(page,size);
    }
}
