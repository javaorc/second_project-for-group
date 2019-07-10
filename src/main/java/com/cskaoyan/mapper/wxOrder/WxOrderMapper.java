package com.cskaoyan.mapper.wxOrder;

import com.cskaoyan.bean.Address;
import com.cskaoyan.bean.Cart;
import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.OrderGoods;
import com.cskaoyan.bean.wxBean.WxOrder;
import com.cskaoyan.bean.wxBean.WxOrderDetail;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;

import java.util.List;

public interface WxOrderMapper {
    List<WxOrder> showOrders(@Param("uid") Integer UserId);

    WxOrderDetail queryDetailByOid(@Param("oid")Integer OrderId);

    int deleteOrder(@Param("oid")Integer OrderId);

    int changeOrderStatus(@Param("status")Integer status,@Param("oid")Integer OrderId);

    OrderGoods queryOGByOidAndGid(@Param("oid")Integer orderId,@Param("gid")Integer goodsId);

    OrderGoods queryOGById(@Param("ogid")Integer ogid);

    int createNewComment(@Param("og")OrderGoods orderGoods, @Param("uid") Integer userId,@Param("temp")Integer temp,@Param("star")Integer star,@Param("comment")String comment);

    int updateComment(@Param("og")OrderGoods orderGoods);

    Cart queryCartByCid(@Param("cid")Integer cid);

    List<Cart> queryCartByChecked();

    Address queryAddressByAid(@Param("aid")Integer aid);

    int insertOrder(@Param("order") Order order);

    int insertOrderGoods(@Param("og")OrderGoods orderGoods);
}
