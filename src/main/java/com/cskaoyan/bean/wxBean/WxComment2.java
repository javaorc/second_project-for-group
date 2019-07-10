package com.cskaoyan.bean.wxBean;

import java.util.Date;
import java.util.List;

public class WxComment2 {

    private WxUserInfo userInfo;

    private Date addTime;

    private List<String> picList;

    private String content;

    public WxUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(WxUserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public List<String> getPicList() {
        return picList;
    }

    public void setPicList(List<String> picList) {
        this.picList = picList;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public WxComment2() {

    }

    public WxComment2(WxUserInfo userInfo, Date addTime, List<String> picList, String content) {
        this.userInfo = userInfo;
        this.addTime = addTime;
        this.picList = picList;
        this.content = content;
    }

}

