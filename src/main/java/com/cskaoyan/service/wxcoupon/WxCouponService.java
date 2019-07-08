package com.cskaoyan.service.wxcoupon;

import com.cskaoyan.bean.vo.ResponseVO;

import java.util.Map;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/8 15:17
 **/
public interface WxCouponService {
    ResponseVO<Map<String, Object>> couponList(int page, int size);
}
