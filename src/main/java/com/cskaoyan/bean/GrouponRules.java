package com.cskaoyan.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/5 15:46
 **/
public class GrouponRules {
    private Integer         id;
    private Integer         goodsId;
    private String          goodsName;
    private String          picUrl;
    private double          discount;
    private Integer         discountMember;
    private Date            addTime;
    private Date            updateTime;
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date            expireTime;
    private Boolean         deleted;
    private Goods goods;
    private Integer groupon_member;
    private Integer groupon_price;

    public Integer getGroupon_member() {
        return groupon_member;
    }

    public void setGroupon_member(Integer groupon_member) {
        this.groupon_member = groupon_member;
    }

    public Integer getGroupon_price() {
        return groupon_price;
    }

    public void setGroupon_price(Integer groupon_price) {
        this.groupon_price = groupon_price;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

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
}
