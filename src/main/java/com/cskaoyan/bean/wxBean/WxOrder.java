package com.cskaoyan.bean.wxBean;

import com.cskaoyan.bean.wxgrouponrela.HandleOption;

import java.math.BigDecimal;
import java.util.List;

public class WxOrder {

    private Integer    id;

    private boolean    isGroupin;

    private String    orderSn;

    private String     orderStatusText;

    private BigDecimal actualPrice;


    private Integer OrderStatus;

    private String comments;

    private HandleOption handleOption;

    private List<WxOrderGoods> goodsList;

    public Integer getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        OrderStatus = orderStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isGroupin() {
        return isGroupin;
    }

    public void setGroupin(boolean groupin) {
        isGroupin = groupin;
    }


    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public void setOrderStatusText(String orderStatusText) {
        this.orderStatusText = orderStatusText;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public HandleOption getHandleOption() {
        return handleOption;
    }

    public void setHandleOption(HandleOption handleOption) {
        this.handleOption = handleOption;
    }

    public List<WxOrderGoods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<WxOrderGoods> goodsList) {
        this.goodsList = goodsList;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
