package com.cskaoyan.bean.wxBean;

import com.cskaoyan.bean.GoodsSpecification;

public class WxGoodsSpecification {

    private String name;

    private GoodsSpecification[] goodsSpecifications;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GoodsSpecification[] getGoodsSpecifications() {
        return goodsSpecifications;
    }

    public void setGoodsSpecifications(GoodsSpecification[] goodsSpecifications) {
        this.goodsSpecifications = goodsSpecifications;
    }

    public WxGoodsSpecification() {

    }

    public WxGoodsSpecification(String name, GoodsSpecification[] goodsSpecifications) {
        this.name = name;
        this.goodsSpecifications = goodsSpecifications;
    }
}
