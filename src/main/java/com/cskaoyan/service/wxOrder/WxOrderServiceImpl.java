package com.cskaoyan.service.wxOrder;

import com.cskaoyan.bean.Address;
import com.cskaoyan.bean.Cart;
import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.OrderGoods;
import com.cskaoyan.bean.wxBean.WxOrder;
import com.cskaoyan.bean.wxBean.WxOrderDetail;
import com.cskaoyan.mapper.wxOrder.WxOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WxOrderServiceImpl implements WxOrderService {
    @Autowired(required =false)
    WxOrderMapper wxOrderMapper;
    @Override
    public List<WxOrder> showOrders(Integer UserId) {
        return wxOrderMapper.showOrders(UserId);
    }

    @Override
    public WxOrderDetail queryDetailByOid(Integer OrderId) {
        return wxOrderMapper.queryDetailByOid(OrderId);
    }

    @Override
    public int deleteOrder(Integer OrderId) {
        return wxOrderMapper.deleteOrder(OrderId);
    }

    @Override
    public int changeOrderStatus(Integer status,Integer OrderId) {
        return wxOrderMapper.changeOrderStatus(status,OrderId);
    }

    @Override
    public OrderGoods queryOGByOidAndGid(Integer orderId, Integer goodsId) {
        return wxOrderMapper.queryOGByOidAndGid(orderId,goodsId);
    }

    @Override
    public OrderGoods queryOGById(Integer ogid) {
        return wxOrderMapper.queryOGById(ogid);
    }

    @Override
    public int createNewComment(OrderGoods orderGoods,Integer userId,Integer temp,Integer star,String comment) {
        return wxOrderMapper.createNewComment(orderGoods,userId,temp,star,comment);
    }

    @Override
    public int updateComment(OrderGoods orderGoods) {
        return wxOrderMapper.updateComment(orderGoods);
    }

    @Override
    public Cart queryCartByCid(Integer cid) {
        return wxOrderMapper.queryCartByCid(cid);
    }

    @Override
    public List<Cart> queryCartByChecked() {
        return wxOrderMapper.queryCartByChecked();
    }

    @Override
    public Address queryAddressByAid(Integer aid) {
        return wxOrderMapper.queryAddressByAid(aid);
    }

    @Override
    public int insertOrder(Order order) {
        return wxOrderMapper.insertOrder(order);
    }

    @Override
    public int insertOrderGoods(OrderGoods orderGoods) {
        return wxOrderMapper.insertOrderGoods(orderGoods);
    }
}
