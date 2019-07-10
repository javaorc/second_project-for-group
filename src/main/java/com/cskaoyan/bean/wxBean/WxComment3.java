package com.cskaoyan.bean.wxBean;

import com.cskaoyan.bean.User;

import java.util.Date;
import java.util.List;

public class WxComment3 {

    private String id;

    private String nickname;

    private Date addTime;

    private String content;

    private String avatar;

    private List<String> picList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<String> getPicList() {
        return picList;
    }

    public void setPicList(List<String> picList) {
        this.picList = picList;
    }

    public WxComment3() {

    }

    public WxComment3(String id, String nickname, Date addTime, String content, String avatar, List<String> picList) {
        this.id = id;
        this.nickname = nickname;
        this.addTime = addTime;
        this.content = content;
        this.avatar = avatar;
        this.picList = picList;
    }
}
