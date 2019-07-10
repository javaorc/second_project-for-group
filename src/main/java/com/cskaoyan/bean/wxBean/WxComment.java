package com.cskaoyan.bean.wxBean;

import com.cskaoyan.bean.Comment;

import java.util.List;

public class WxComment<T> {

    List<T> data;

    Integer count;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public WxComment() {

    }

    public WxComment(List<T> data, Integer count) {
        this.data = data;
        this.count = count;
    }

}
