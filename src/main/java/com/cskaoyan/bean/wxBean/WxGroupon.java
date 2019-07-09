package com.cskaoyan.bean.wxBean;

public class WxGroupon {
    private WxGoods goods;
    private double groupon_member;
    private double groupon_price;

    public WxGoods getGoods() {
        return goods;
    }

    public void setGoods(WxGoods goods) {
        this.goods = goods;
    }

    public double getGroupon_member() {
        return groupon_member;
    }

    public void setGroupon_member(double groupon_member) {
        this.groupon_member = groupon_member;
    }

    public double getGroupon_price() {
        return groupon_price;
    }

    public void setGroupon_price(double groupon_price) {
        this.groupon_price = groupon_price;
    }
}
