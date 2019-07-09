package com.cskaoyan.bean;

public class OrderType {
    private Integer uncomment;

    private Integer unpaid;

    private Integer unrecv;

    private Integer unship;

    public Integer getUncomment() {
        return uncomment;
    }

    public void setUncomment(Integer uncomment) {
        this.uncomment = uncomment;
    }

    public Integer getUnpaid() {
        return unpaid;
    }

    public void setUnpaid(Integer unpaid) {
        this.unpaid = unpaid;
    }

    public Integer getUnrecv() {
        return unrecv;
    }

    public void setUnrecv(Integer unrecv) {
        this.unrecv = unrecv;
    }

    public Integer getUnship() {
        return unship;
    }

    public void setUnship(Integer unship) {
        this.unship = unship;
    }

    public OrderType() {
    }

    public OrderType(Integer uncomment, Integer unpaid, Integer unrecv, Integer unship) {
        this.uncomment = uncomment;
        this.unpaid = unpaid;
        this.unrecv = unrecv;
        this.unship = unship;
    }
}
