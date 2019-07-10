package com.cskaoyan.controller.generalize;

import com.cskaoyan.OperationLog.OperationLog;
import com.cskaoyan.bean.Coupon;
import com.cskaoyan.bean.CouponUser;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.SystemService;
import com.cskaoyan.service.generalize.CouponService;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/4 14:07
 **/
@RestController
@RequestMapping("admin")
@Api(tags = "优惠券管理",description = "CouponController是推广管理模块中优惠券管理的Controller")
public class CouponController {

    @Autowired
    CouponService couponService;
    @Autowired
    SystemService systemService;

    @RequestMapping("coupon/list")
    @RequiresPermissions(value = "admin:coupon:list")
    public ResponseVO<Map<String, Object>> couponList(String name,Short type,Short status, int page,int limit,String sort,String order){
        return couponService.findCouponList(name,type,status,page,limit);
    }

    @RequestMapping("coupon/create")
    @RequiresPermissions(value = "admin:coupon:create")
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
    @RequiresPermissions(value = "admin:coupon:read")
    public ResponseVO<Coupon> read(int id){
        ResponseVO<Coupon> responseVO =new ResponseVO<>();
        responseVO.setErrmsg("成功");
        Coupon coupon = couponService.readCouponById(id);
        responseVO.setData(coupon);
        return responseVO;
    }
    @RequestMapping("coupon/listuser")
    @RequiresPermissions(value = "admin:coupon:listuser")
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
    @RequiresPermissions(value = "admin:coupon:update")
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
    @RequiresPermissions(value = "admin:coupon:delete")
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
