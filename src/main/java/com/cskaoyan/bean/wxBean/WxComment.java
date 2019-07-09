package com.cskaoyan.bean.wxBean;

import com.cskaoyan.bean.Comment;

public class WxComment {

    Comment[] data;

    Integer count;

    public Comment[] getData() {
        return data;
    }

    public void setData(Comment[] data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public WxComment(Comment[] data, Integer count) {
        this.data = data;
        this.count = count;
    }

    public WxComment() {

    }

}
