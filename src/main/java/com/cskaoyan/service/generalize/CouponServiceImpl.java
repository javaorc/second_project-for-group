package com.cskaoyan.service.generalize;

import com.cskaoyan.bean.Coupon;
import com.cskaoyan.bean.CouponUser;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.mapper.generalize.CouponMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/4 14:13
 **/
@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    CouponMapper couponMapper;

    ResponseVO<Map<String, Object>> mapResponseVO = new ResponseVO<>();

    Map<String, Object> map = new HashMap<>();

    @Override
    public ResponseVO<Map<String, Object>> findCouponList(String name, Short type,
                                                          Short status,int page,int limit) {
        if("".equals(name)){
            name=null;
        }
        if("".equals(type)){
            type=null;
        }if("".equals(status)){
            status=null;
        }
        List<Coupon> couponList = couponMapper.findCouponList(name, type, status);
        //分页
        PageHelper.startPage(page,limit);
        PageInfo<Coupon> couponPageInfo = new PageInfo<>(couponList);
        map.put("total", couponPageInfo.getTotal());
        map.put("items", couponList);
        //封装
        mapResponseVO.setData(map);
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setErrno(0);
        return  mapResponseVO;
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

    @Override
    public List<Coupon> queryCoupons() {
        return couponMapper.queryCoupons();
    }
}
