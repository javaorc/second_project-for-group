package com.cskaoyan.bean.wxBean;

import com.cskaoyan.bean.Comment;

import java.util.List;

public class WxComment {

    List<Comment> data;

    Integer count;

    public List<Comment> getData() {
        return data;
    }

    public void setData(List<Comment> data) {
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

    public WxComment(List<Comment> data, Integer count) {
        this.data = data;
        this.count = count;
    }

}
