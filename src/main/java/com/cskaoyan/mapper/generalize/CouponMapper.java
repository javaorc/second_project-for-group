package com.cskaoyan.mapper.generalize;

import com.cskaoyan.bean.Coupon;
import com.cskaoyan.bean.CouponUser;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/4 14:17
 **/
public interface CouponMapper {

    List<Coupon> findCouponList(@Param("name") String name,
                                @Param("type")Short type,
                                @Param("status")Short status);

    int insertCoupon(@Param("coupon") Coupon coupon);

    Coupon readCouponById(@Param("id") int id);

    List<CouponUser> queryUserByCouponId(@Param("id") int couponId,
                                         @Param("userId") Integer userId,
                                         @Param("status") Integer status);

    Coupon queryCouponByAddTime(@Param("date") Date date);

    int updateCoupon(@Param("coupon") Coupon coupon);

    int deleteCoupon(@Param("coupon") Coupon coupon);

    List<Coupon> queryCoupons();
}
