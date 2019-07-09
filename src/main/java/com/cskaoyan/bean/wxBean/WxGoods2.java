package com.cskaoyan.bean.wxBean;

public class WxGoods2 {

    private Integer id;

    private String name;

    private String brief;

    private String picUrl;

    private boolean isNew;

    private boolean isHot;

    private Integer counterPrice;

    private Integer retailPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public Integer getCounterPrice() {
        return counterPrice;
    }

    public void setCounterPrice(Integer counterPrice) {
        this.counterPrice = counterPrice;
    }

    public Integer getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Integer retailPrice) {
        this.retailPrice = retailPrice;
    }

    public WxGoods2() {

    }

    public WxGoods2(Integer id, String name, String brief, String picUrl, boolean isNew, boolean isHot, Integer counterPrice, Integer retailPrice) {
        this.id = id;
        this.name = name;
        this.brief = brief;
        this.picUrl = picUrl;
        this.isNew = isNew;
        this.isHot = isHot;
        this.counterPrice = counterPrice;
        this.retailPrice = retailPrice;
    }

}
