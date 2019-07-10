package com.cskaoyan.service.wxOrder;

import com.cskaoyan.bean.OrderGoods;
import com.cskaoyan.bean.wxBean.WxOrder;
import com.cskaoyan.bean.wxBean.WxOrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxOrderService {
    List<WxOrder> showOrders(Integer UserId);

    WxOrderDetail queryDetailByOid(Integer OrderId);

    int deleteOrder(Integer OrderId);

    int changeOrderStatus(Integer status,Integer OrderId);

    OrderGoods queryOGByOidAndGid(Integer orderId,Integer goodsId);

    OrderGoods queryOGById(Integer ogid);

    int createNewComment(OrderGoods orderGoods,Integer userId,Integer temp,Integer star,String comment);

    int updateComment(OrderGoods orderGoods);
}
