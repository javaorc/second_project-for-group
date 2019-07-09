package com.cskaoyan.bean.wxgrouponrela;

import com.cskaoyan.bean.Groupon;
import com.cskaoyan.bean.GrouponRules;
import com.cskaoyan.bean.Order;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/8 20:36
 **/
public class GrouponMy {
    private Integer id;
    private String creator;
    private Boolean isCreator;
    private Integer actualPrice;
    private Integer joinerCount;
    private Integer orderId;
    private String orderSn;
    private Integer orderStatus;
    private String orderStatusText;
    private int [] goodsList;
    private Groupon groupon;
    private HandleOption handleOption;
    private GrouponRules grouponRules;

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    public Boolean getIsCreator(){
        return isCreator;
    }
    public void setIsCreator(Boolean isCreator){
        this.isCreator=isCreator;
    }

    public Integer getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(Integer actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Integer getJoinerCount() {
        return joinerCount;
    }

    public void setJoinerCount(Integer joinerCount) {
        this.joinerCount = joinerCount;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public int[] getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(int[] goodsList) {
        this.goodsList = goodsList;
    }

    public Groupon getGroupon() {
        return groupon;
    }

    public void setGroupon(Groupon groupon) {
        this.groupon = groupon;
    }

    public HandleOption getHandleOption() {
        return handleOption;
    }

    public void setHandleOption(HandleOption handleOption) {
        this.handleOption = handleOption;
    }

    public GrouponRules getGrouponRules() {
        return grouponRules;
    }

    public void setGrouponRules(GrouponRules grouponRules) {
        this.grouponRules = grouponRules;
    }


}
