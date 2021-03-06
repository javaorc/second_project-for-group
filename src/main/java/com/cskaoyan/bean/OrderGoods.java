package com.cskaoyan.bean;

import java.math.BigDecimal;
import java.util.Date;

public class OrderGoods {
    private Integer         id;

    private Integer         orderId;

    private  Order          order;

    private Integer         goodsId;

    private Goods           goods;

    private String          goodsName;

    private String          goodsSn;

    private Integer         productId;

    private GoodsProduct    goodsProduct;

    private Short           number;

    private  BigDecimal     price;

    private String          specifications;

    private String          picUrl;

    private Integer         comment;

    private Date            addTime;

    private Date            updateTime;

    private Boolean         deleted;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public GoodsProduct getGoodsProduct() {
        return goodsProduct;
    }

    public void setGoodsProduct(GoodsProduct goodsProduct) {
        this.goodsProduct = goodsProduct;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn == null ? null : goodsSn.trim();
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Short getNumber() {
        return number;
    }

    public void setNumber(Short number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public OrderGoods(Integer orderId, Order order, Integer goodsId, Goods goods, String goodsName, String goodsSn, Integer productId, GoodsProduct goodsProduct, Short number, BigDecimal price, String specifications, String picUrl, Integer comment, Date addTime, Date updateTime, Boolean deleted) {
        this.orderId = orderId;
        this.order = order;
        this.goodsId = goodsId;
        this.goods = goods;
        this.goodsName = goodsName;
        this.goodsSn = goodsSn;
        this.productId = productId;
        this.goodsProduct = goodsProduct;
        this.number = number;
        this.price = price;
        this.specifications = specifications;
        this.picUrl = picUrl;
        this.comment = comment;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }

    public OrderGoods() {
    }
}