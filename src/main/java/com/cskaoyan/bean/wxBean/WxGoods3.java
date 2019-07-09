package com.cskaoyan.bean.wxBean;

import java.util.List;

public class WxGoods3 {

    private List<WxGoods2> goodsList;

    public List<WxGoods2> getList() {
        return goodsList;
    }

    public void setList(List<WxGoods2> list) {
        this.goodsList = list;
    }

    public WxGoods3(List<WxGoods2> list) {
        this.goodsList = list;
    }

    public WxGoods3() {

    }

}
