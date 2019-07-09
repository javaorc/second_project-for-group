package com.cskaoyan.mapper.wxcoupon;

import com.cskaoyan.bean.Coupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/8 15:20
 **/
public interface WxCouponMapper {
    List<Coupon> queryCouponList();

    List<Coupon> queryCouponByStatus(@Param("status") Integer status);

    Coupon queryCouponByCode(@Param("code") String code);
}
