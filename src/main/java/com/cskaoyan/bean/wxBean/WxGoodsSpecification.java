package com.cskaoyan.bean.wxBean;

import com.cskaoyan.bean.GoodsSpecification;

import java.util.List;

public class WxGoodsSpecification {

    private String name;

    private List<GoodsSpecification> valueList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GoodsSpecification> getValueList() {
        return valueList;
    }

    public void setValueList(List<GoodsSpecification> valueList) {
        this.valueList = valueList;
    }

    public WxGoodsSpecification(String name, List<GoodsSpecification> valueList) {
        this.name = name;
        this.valueList = valueList;
    }

    public WxGoodsSpecification() {

    }

}
