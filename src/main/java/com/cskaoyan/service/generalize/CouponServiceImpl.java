package com.cskaoyan.service.generalize;

import com.cskaoyan.bean.Coupon;
import com.cskaoyan.bean.CouponUser;
import com.cskaoyan.mapper.generalize.CouponMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/4 14:13
 **/
@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    CouponMapper couponMapper;

    @Override
    public List<Coupon> findCouponList(String name, Short type, Short status) {
        return couponMapper.findCouponList(name,type,status);
    }

    @Override
    public int insertCoupon(Coupon coupon) {
        return couponMapper.insertCoupon(coupon);
    }

    @Override
    public Coupon readCouponById(int id) {
        return couponMapper.readCouponById(id);
    }

    @Override
    public List<CouponUser> queryUserByCouponId(int couponId,Integer userId,Integer status) {
        return couponMapper.queryUserByCouponId(couponId,userId,status);
    }

    @Override
    public Coupon queryCouponByAddTime(Date date) {
        return couponMapper.queryCouponByAddTime(date);
    }

    @Override
    public int updateCoupon(Coupon coupon) {
        return couponMapper.updateCoupon(coupon);
    }

    @Override
    public int deleteCoupon(Coupon coupon) {
        return couponMapper.deleteCoupon(coupon);
    }
}
