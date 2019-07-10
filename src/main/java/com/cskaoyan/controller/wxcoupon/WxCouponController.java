package com.cskaoyan.controller.wxcoupon;

import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.wxcoupon.WxCouponService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("coupon/receive")
    @ResponseBody
    public ResponseVO<Map<String,Object>> couponReceive(Integer couponId){
        //此处逻辑待补充
        mapResponseVO.setErrno(0);
        mapResponseVO.setErrmsg("成功");
        return mapResponseVO;
    }

    @RequestMapping("coupon/mylist")
    @ResponseBody
    public ResponseVO<Map<String,Object>> couponMyList(Integer status,Integer page,Integer size){
        return couponService.queryCouponByStatus(status,page,size);
    }

    @RequestMapping("coupon/exchange")
    @ResponseBody
    public ResponseVO<Map<String,Object>> couponExchange(@RequestBody Map map){
        String code = (String) map.get("code");
        System.out.println(1);
        return couponService.couponExchange(code);
    }

    @RequestMapping("coupon/selectlist")
    @ResponseBody
    public ResponseVO<Map<String,Object>> selectList(Integer cartId,Integer grouponRulesId){
        return couponService.selectList(cartId,grouponRulesId);
    }


}
