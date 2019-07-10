package com.cskaoyan.bean;

import java.math.BigDecimal;
import java.util.List;

public class LzgOrder {
    Address address;
    List<Cart> carts;
    BigDecimal actualPrice;
    int addressId;
    int couponId;
    BigDecimal couponPrice;
    BigDecimal freightPrice;
    BigDecimal goodsTotalPrice;
    int grouponRulesId;
    BigDecimal orderTotalPrice;

    @Override
    public String toString() {
        return "LzgOrder{" +
                "address=" + address +
                ", carts=" + carts +
                ", actualPrice=" + actualPrice +
                ", addressId=" + addressId +
                ", couponId=" + couponId +
                ", couponPrice=" + couponPrice +
                ", freightPrice=" + freightPrice +
                ", goodsTotalPrice=" + goodsTotalPrice +
                ", grouponRulesId=" + grouponRulesId +
                ", orderTotalPrice=" + orderTotalPrice +
                '}';
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }

    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
    }

    public BigDecimal getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(BigDecimal goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public int getGrouponRulesId() {
        return grouponRulesId;
    }

    public void setGrouponRulesId(int grouponRulesId) {
        this.grouponRulesId = grouponRulesId;
    }

    public BigDecimal getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }
}
