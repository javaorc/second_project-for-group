package com.cskaoyan.bean.wxBean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class WxGrouponRules {

    private Integer id;

    private Integer goodsId;

    private String goodsName;

    private String picUrl;

    private double discount;

    private Integer discountMember;
    @JsonFormat( pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date addTime;
    @JsonFormat( pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date updateTime;
    @JsonFormat( pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date expireTime;

    private Boolean deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Integer getDiscountMember() {
        return discountMember;
    }

    public void setDiscountMember(Integer discountMember) {
        this.discountMember = discountMember;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public WxGrouponRules() {

    }

    public WxGrouponRules(Integer id, Integer goodsId, String goodsName, String picUrl, double discount, Integer discountMember, Date addTime, Date updateTime, Date expireTime, Boolean deleted) {
        this.id = id;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.picUrl = picUrl;
        this.discount = discount;
        this.discountMember = discountMember;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.expireTime = expireTime;
        this.deleted = deleted;
    }

}
