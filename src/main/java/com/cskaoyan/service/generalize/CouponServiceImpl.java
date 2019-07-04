package com.cskaoyan.service.generalize;

import com.cskaoyan.bean.Coupon;
import com.cskaoyan.mapper.generalize.CouponMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
