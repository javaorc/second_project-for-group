package com.cskaoyan.service.wxGoods;

import com.cskaoyan.bean.History;
import com.cskaoyan.mapper.wxGoods.WxSearchHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class WxSearchHistoryServiceImpl implements WxSearchHistoryService{
    @Autowired
    WxSearchHistoryMapper searchHistoryMapper;
    @Override
    public void addSearchHistory(String keyword,Integer userId) {
        History history = new History();
        Date date = new Date();
        history.setDeleted(false);
        history.setAddTime(date);
        history.setUpdateTime(date);
        history.setFrom("微信");
        history.setKeyword(keyword);
        history.setUserId(userId);
        searchHistoryMapper.addSearchHistory(history);
    }
}
