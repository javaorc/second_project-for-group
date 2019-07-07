package com.cskaoyan.service.mallManegeServiceImpl;

import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.OrderCGoods;
import com.cskaoyan.mapper.mallManege.MallOrderMapper;
import com.cskaoyan.service.MallOrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MallOrderServiceImpl implements MallOrderService {
    @Autowired
    MallOrderMapper mallOrderMapper;

    @Override
    public List<Order> showAllOrder() {
        return mallOrderMapper.showAllOrder();
    }

    @Override
    public List<Order> searchOrderByInfo(Integer status, Integer userId, String orderSn) {
        return mallOrderMapper.searchOrderByInfo(status,userId,orderSn);
    }

    @Override
    public OrderCGoods searchOrderGoods(Integer id) {
        return mallOrderMapper.searchOrderGoods(id);
    }
}
