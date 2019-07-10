package com.cskaoyan.bean.wxBean;

import com.cskaoyan.bean.wxgrouponrela.HandleOption;

public class WxOrderGoods {
    private Integer id;

    private String  goodsName;

    private Integer number;

    private String  picUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public WxOrderGoods(Integer id, String goodsName, Integer number, String picUrl) {
        this.id = id;
        this.goodsName = goodsName;
        this.number = number;
        this.picUrl = picUrl;
    }

    public WxOrderGoods() {
    }
}
