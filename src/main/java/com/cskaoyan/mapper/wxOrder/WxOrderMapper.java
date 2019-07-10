package com.cskaoyan.mapper.wxOrder;

import com.cskaoyan.bean.OrderGoods;
import com.cskaoyan.bean.wxBean.WxOrder;
import com.cskaoyan.bean.wxBean.WxOrderDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;

import java.util.List;

public interface WxOrderMapper {
    List<WxOrder> showOrders(@Param("uid") Integer UserId);

    WxOrderDetail queryDetailByOid(@Param("oid")Integer OrderId);

    int deleteOrder(@Param("oid")Integer OrderId);

    int changeOrderStatus(@Param("status")Integer status,@Param("oid")Integer OrderId);

    OrderGoods queryOGByOidAndGid(@Param("oid")Integer orderId,@Param("gid")Integer goodsId);
}
