package com.cskaoyan.bean.wxBean;

public class WxUserInfo{

    private String nickName;

    private String avatarUrl;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public WxUserInfo() {

    }

    public WxUserInfo(String nickName, String avatarUrl) {
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
    }

}