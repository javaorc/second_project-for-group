package com.cskaoyan.service.generalize;

import com.cskaoyan.bean.Coupon;
import com.cskaoyan.bean.CouponUser;

import java.util.Date;
import java.util.List;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/4 14:13
 **/
public interface CouponService {
    List<Coupon> findCouponList(String name, Short type, Short status);

    int insertCoupon(Coupon coupon);

    Coupon readCouponById(int id);

    List<CouponUser> queryUserByCouponId(int couponId,Integer userId,Integer status);

    Coupon queryCouponByAddTime(Date date);

    int updateCoupon(Coupon coupon);

    int deleteCoupon(Coupon coupon);
}
