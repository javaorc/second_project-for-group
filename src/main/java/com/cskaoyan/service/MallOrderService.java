package com.cskaoyan.service;

import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.OrderCGoods;

import java.util.List;

public interface MallOrderService {
    List<Order> showAllOrder();

    List<Order> searchOrderByInfo(Integer status,Integer userId,String orderSn);

    OrderCGoods searchOrderGoods(Integer id );
}
