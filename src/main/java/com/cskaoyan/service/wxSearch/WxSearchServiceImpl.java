package com.cskaoyan.service.wxSearch;

import com.cskaoyan.mapper.wxSearch.WxSearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WxSearchServiceImpl implements WxSearchService {

    @Autowired
    WxSearchMapper searchMapper;

    /*进入页面*/
    @Override
    public Map<String, Object> queryKeywordList(Integer uid) {
        Map<String, Object> map = new HashMap<>();

        map.put("defaultKeyword", searchMapper.queryDefaultKeyword());
        if (uid != null) {
            map.put("historyKeywordList", searchMapper.queryHistoryKeywordList(uid));
        } else {
            map.put("historyKeywordList", null);
        }
        map.put("hotKeywordList", searchMapper.queryHotKeywordList());
        return map;
    }

    /*清除关键字历史记录*/
    @Override
    public int clearHistoryKeyword(Integer userId) {
        return searchMapper.clearHistoryKeyword(userId);
    }
}
