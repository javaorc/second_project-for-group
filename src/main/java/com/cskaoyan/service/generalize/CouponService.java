package com.cskaoyan.service.generalize;

import com.cskaoyan.bean.Coupon;

import java.util.List;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/4 14:13
 **/
public interface CouponService {
    List<Coupon> findCouponList(String name, Short type, Short status);
}
