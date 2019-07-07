package com.cskaoyan.service.generalize;

import com.cskaoyan.bean.Coupon;
import com.cskaoyan.bean.CouponUser;
import com.cskaoyan.bean.vo.ResponseVO;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/4 14:13
 **/
public interface CouponService {
    ResponseVO<Map<String, Object>> findCouponList(String name, Short type, Short status,
                                                   int page,int limit);

    int insertCoupon(Coupon coupon);

    Coupon readCouponById(int id);

    List<CouponUser> queryUserByCouponId(int couponId,Integer userId,Integer status);

    Coupon queryCouponByAddTime(Date date);

    int updateCoupon(Coupon coupon);

    int deleteCoupon(Coupon coupon);
}
