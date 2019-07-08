package com.cskaoyan.bean;

public class UserInfo {
    private String avatarUrl;
    private String nickName;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public UserInfo() {
    }

    public UserInfo(String avatarUrl, String nickName) {
        this.avatarUrl = avatarUrl;
        this.nickName = nickName;
    }
}
