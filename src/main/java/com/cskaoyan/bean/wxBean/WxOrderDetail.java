package com.cskaoyan.bean.wxBean;

import com.cskaoyan.bean.OrderGoods;
import com.cskaoyan.bean.wxgrouponrela.HandleOption;

import java.util.List;

public class WxOrderDetail {


    private WxOrderInfo orderInfo;

    private List<OrderGoods> orderGoods;

    public WxOrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(WxOrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public List<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }
}
