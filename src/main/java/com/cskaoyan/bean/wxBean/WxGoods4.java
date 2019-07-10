package com.cskaoyan.bean.wxBean;

import com.cskaoyan.bean.Collect;
import com.cskaoyan.bean.Goods;

public class WxGoods4 {
    String brief;
    int id;
    String name;
    String picUrl;
    double retailPrice;
    byte type;
    int valueId;

    public void trans(Goods goods, Collect collect){
        if (goods!=null){
            this.brief=goods.getBrief();
            this.id=goods.getId();
            this.name=goods.getName();
            this.picUrl=goods.getPicUrl();
            this.retailPrice=goods.getRetailPrice();
        }

        this.type=collect.getType();
        this.valueId=collect.getValueId();
    }


    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(int retailPrice) {
        this.retailPrice = retailPrice;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public int getValueId() {
        return valueId;
    }

    public void setValueId(int valueId) {
        this.valueId = valueId;
    }
}
