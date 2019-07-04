package com.cskaoyan.mapper.generalize;

import com.cskaoyan.bean.Coupon;
import org.apache.ibatis.annotations.Param;

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
}
