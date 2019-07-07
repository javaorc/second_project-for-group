package com.cskaoyan.mapper.mallManege;

import com.cskaoyan.bean.Goods;
import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.OrderCGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MallOrderMapper {
    List<Order> showAllOrder();

    List<Order> searchOrderByInfo(@Param("status")Integer status,@Param("uid")Integer userId,@Param("osn")String orderSn);

    OrderCGoods searchOrderGoods(@Param("id")Integer id );
}
