package com.cskaoyan.service.wxcoupon;

import com.cskaoyan.bean.Coupon;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.mapper.wxcoupon.WxCouponMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/8 15:17
 **/
@Service
public class WxCouponServiceImpl implements WxCouponService {

    @Autowired
    WxCouponMapper wxCouponMapper;

    ResponseVO<Map<String, Object>> mapResponseVO = new ResponseVO<>();

    Map<String, Object> map = new HashMap<>();

    @Override
    public ResponseVO<Map<String, Object>> couponList(int page, int size) {
        List<Coupon> couponList = wxCouponMapper.queryCouponList();
        PageHelper.startPage(page,size);
        PageInfo<Coupon> couponPageInfo = new PageInfo<>(couponList);
        map.put("count", couponPageInfo.getTotal());
        map.put("data", couponList);
        mapResponseVO.setData(map);
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setErrno(0);
        return mapResponseVO;
    }

    @Override
    public ResponseVO<Map<String, Object>> queryCouponByStatus(Integer status, Integer page, Integer size) {
        List<Coupon> couponList = wxCouponMapper.queryCouponByStatus(status);
        PageHelper.startPage(page,size);
        PageInfo<Coupon> couponPageInfo = new PageInfo<>(couponList);
        map.put("count",couponPageInfo.getTotal());
        map.put("data",couponList);
        mapResponseVO.setData(map);
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setErrno(0);
        return mapResponseVO;
    }

    @Override
    public ResponseVO<Map<String, Object>> couponExchange(String code) {
        Coupon coupon = wxCouponMapper.queryCouponByCode(code);
        if(coupon!=null){
            mapResponseVO.setErrmsg("成功");
            mapResponseVO.setErrno(0);
            mapResponseVO.setData(null);
        }else{
            mapResponseVO.setErrmsg("优惠券不正确");
            mapResponseVO.setErrno(742);
            mapResponseVO.setData(null);
        }
        return mapResponseVO;
    }


}
