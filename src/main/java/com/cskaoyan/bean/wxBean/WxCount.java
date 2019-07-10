package com.cskaoyan.bean.wxBean;

public class WxCount {

    private int allCount;

    private int hasPicCount;

    public int getAllCount() {
        return allCount;
    }

    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }

    public int getHasPicCount() {
        return hasPicCount;
    }

    public void setHasPicCount(int hasPicCount) {
        this.hasPicCount = hasPicCount;
    }

    public WxCount() {

    }

    public WxCount(int allCount, int hasPicCount) {
        this.allCount = allCount;
        this.hasPicCount = hasPicCount;
    }

}
