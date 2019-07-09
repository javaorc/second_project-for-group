package com.cskaoyan.controller.generalize;

import com.cskaoyan.OperationLog.OperationLog;
import com.cskaoyan.bean.Coupon;
import com.cskaoyan.bean.CouponUser;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.SystemService;
import com.cskaoyan.service.generalize.CouponService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

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
    @Autowired
    SystemService systemService;

    @RequestMapping("coupon/list")
    @ResponseBody
    public ResponseVO<Map<String, Object>> couponList(String name,Short type,Short status, int page,int limit,String sort,String order){
        return couponService.findCouponList(name,type,status,page,limit);
    }

    @RequestMapping("coupon/create")
    @ResponseBody
    public ResponseVO<Coupon> couponCreate(@RequestBody Coupon coupon){
        ResponseVO<Coupon> responseVO =new ResponseVO<>();
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        Date date = new Date();
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        String substring = s.substring(1,8);
        coupon.setCode(substring);
        coupon.setAddTime(date);
        coupon.setDeleted(false);
        int i= couponService.insertCoupon(coupon);
        if(i==1){
            String name = (String) SecurityUtils.getSubject().getPrincipal();
            OperationLog operationLog=new OperationLog();
            operationLog.logInsert(systemService,"增加优惠券",name);
            responseVO.setData(coupon);
            return responseVO;
        }
        return null;
    }

    @RequestMapping("coupon/read")
    @ResponseBody
    public ResponseVO<Coupon> read(int id){
        ResponseVO<Coupon> responseVO =new ResponseVO<>();
        responseVO.setErrmsg("成功");
        Coupon coupon = couponService.readCouponById(id);
        responseVO.setData(coupon);
        return responseVO;
    }
    @RequestMapping("coupon/listuser")
    @ResponseBody
    public ResponseVO<Map<String, Object>> listUser(Integer userId,Integer status,int page,int limit,int couponId){
        ResponseVO<Map<String, Object>> mapResponseVO = new ResponseVO<>();
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setErrno(0);
        List<CouponUser> couponUserList= couponService.queryUserByCouponId(couponId,userId,status);
        HashMap<String, Object> map = new HashMap<>();
        map.put("items",couponUserList);
        map.put("total",couponUserList.size());
        mapResponseVO.setData(map);
        return mapResponseVO;
    }

    @RequestMapping("coupon/update")
    @ResponseBody
    public ResponseVO<Coupon> upadateCoupon(@RequestBody Coupon coupon){
        ResponseVO<Coupon> responseVO =new ResponseVO<>();
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        int i =couponService.updateCoupon(coupon);
        if(i==1){
            String name = (String) SecurityUtils.getSubject().getPrincipal();
            OperationLog operationLog=new OperationLog();
            operationLog.logInsert(systemService,"update优惠券",name);
            responseVO.setData(coupon);
            return responseVO;
        }
        return null;
    }

    @RequestMapping("coupon/delete")
    @ResponseBody
    public ResponseVO<Object> deleteCoupon(@RequestBody Coupon coupon){
        ResponseVO<Object> responseVO = new ResponseVO<>();
        int i= couponService.deleteCoupon(coupon);
        if(i==1){
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
            String name = (String) SecurityUtils.getSubject().getPrincipal();
            OperationLog operationLog=new OperationLog();
            operationLog.logInsert(systemService,"delete优惠券",name);
            return responseVO;
        }
        return null;
    }
}
