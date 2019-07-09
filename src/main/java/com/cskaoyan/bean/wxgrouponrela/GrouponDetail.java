package com.cskaoyan.bean.wxgrouponrela;

import com.cskaoyan.bean.Groupon;
import com.cskaoyan.bean.GrouponRules;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/9 15:16
 **/
public class GrouponDetail {
    private Creator creator;
    private Groupon groupon;
    private Joiners joiners;
    private Integer linkGrouponId;
    private int [] orderGoods;
    private OrderInfo orderInfo;
    private GrouponRules grouponRules;

    public GrouponRules getGrouponRules() {
        return grouponRules;
    }

    public void setGrouponRules(GrouponRules grouponRules) {
        this.grouponRules = grouponRules;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public Groupon getGroupon() {
        return groupon;
    }

    public void setGroupon(Groupon groupon) {
        this.groupon = groupon;
    }

    public Joiners getJoiners() {
        return joiners;
    }

    public void setJoiners(Joiners joiners) {
        this.joiners = joiners;
    }

    public Integer getLinkGrouponId() {
        return linkGrouponId;
    }

    public void setLinkGrouponId(Integer linkGrouponId) {
        this.linkGrouponId = linkGrouponId;
    }

    public int[] getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(int[] orderGoods) {
        this.orderGoods = orderGoods;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }


}
