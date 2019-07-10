package com.cskaoyan.service.wxGoods;

import com.cskaoyan.bean.History;

public interface WxSearchHistoryService {
    void addSearchHistory(String keyword,Integer userId);
}
