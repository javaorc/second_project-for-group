package com.cskaoyan.controller;

import com.cskaoyan.bean.Kind;
import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.OrderCGoods;
import com.cskaoyan.bean.OrderGoods;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.mapper.mallManege.MallOrderMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class MallOrderController {
    @Autowired(required = false)
    MallOrderMapper mallOrderMapper;
    @RequestMapping("order/list")
    @ResponseBody
    public ResponseVO<Map<String,Object>> createOrder(Integer page,Integer limit,Integer orderStatusArray,Integer userId,String orderSn) {
        PageHelper.startPage(page,limit);
        Map<String, Object> map = new HashMap<>();
        if(orderStatusArray==null&&orderSn==null&&userId==null) {
            List<Order> orders = mallOrderMapper.showAllOrder();
            PageInfo<Order> orderPageInfo = new PageInfo<>(orders);
            map.put("items", orders);
            map.put("total", orderPageInfo.getTotal());

        }else{
            List<Order> orders = mallOrderMapper.searchOrderByInfo(orderStatusArray, userId, orderSn);
            PageInfo<Order> orderPageInfo = new PageInfo<>(orders);
            map.put("items", orders);
            map.put("total", orderPageInfo.getTotal());
        }
        ResponseVO<Map<String, Object>> responseVO = new ResponseVO<>();
        responseVO.setData(map);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;

    }

    @RequestMapping("order/detail")
    @ResponseBody
    public ResponseVO<Map<String,Object>> showOrderDetail(Integer id) {
        Map<String, Object> map = new HashMap<>();
        OrderCGoods orderCGoods = mallOrderMapper.searchOrderGoods(id);
        System.out.println(orderCGoods);
        Object[] objects = orderCGoods.getOrderGoods().toArray();
        ResponseVO<Map<String, Object>> responseVO = new ResponseVO<>();
        map.put("order",orderCGoods);
        map.put("orderGoods",objects);
        map.put("user",orderCGoods.getUser());
        responseVO.setData(map);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;

    }




}
