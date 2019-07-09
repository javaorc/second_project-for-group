package com.cskaoyan.bean.vo;

import com.cskaoyan.bean.*;
import com.cskaoyan.bean.wxBean.WxComment;
import com.cskaoyan.bean.wxBean.WxGoodsSpecification;

public class GoodsQuery {

    private WxGoodsSpecification specificationList;

    private Groupon[] groupon;

    private Issue[] issue;

    private Integer userHasCollect;

    private String shareImage;

    private WxComment comment;

    private GoodsAttribute[] attribute;

    private Brand brand;

    private GoodsProduct[] productList;

    private Goods info;

    public WxGoodsSpecification getSpecificationList() {
        return specificationList;
    }

    public void setSpecificationList(WxGoodsSpecification specificationList) {
        this.specificationList = specificationList;
    }

    public Groupon[] getGroupon() {
        return groupon;
    }

    public void setGroupon(Groupon[] groupon) {
        this.groupon = groupon;
    }

    public Issue[] getIssue() {
        return issue;
    }

    public void setIssue(Issue[] issue) {
        this.issue = issue;
    }

    public Integer getUserHasCollect() {
        return userHasCollect;
    }

    public void setUserHasCollect(Integer userHasCollect) {
        this.userHasCollect = userHasCollect;
    }

    public String getShareImage() {
        return shareImage;
    }

    public void setShareImage(String shareImage) {
        this.shareImage = shareImage;
    }

    public WxComment getComment() {
        return comment;
    }

    public void setComment(WxComment comment) {
        this.comment = comment;
    }

    public GoodsAttribute[] getAttribute() {
        return attribute;
    }

    public void setAttribute(GoodsAttribute[] attribute) {
        this.attribute = attribute;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public GoodsProduct[] getProductList() {
        return productList;
    }

    public void setProductList(GoodsProduct[] productList) {
        this.productList = productList;
    }

    public Goods getInfo() {
        return info;
    }

    public void setInfo(Goods info) {
        this.info = info;
    }

    public GoodsQuery() {

    }

    public GoodsQuery(WxGoodsSpecification specificationList, Groupon[] groupon, Issue[] issue, Integer userHasCollect, String shareImage, WxComment comment, GoodsAttribute[] attribute, Brand brand, GoodsProduct[] productList, Goods info) {
        this.specificationList = specificationList;
        this.groupon = groupon;
        this.issue = issue;
        this.userHasCollect = userHasCollect;
        this.shareImage = shareImage;
        this.comment = comment;
        this.attribute = attribute;
        this.brand = brand;
        this.productList = productList;
        this.info = info;
    }

}
