package com.cskaoyan.service.wxSearch;

import java.util.Map;

public interface WxSearchService {
    Map<String, Object> queryKeywordList(Integer uid);

    int clearHistoryKeyword(Integer userId);

    int insertSearchKeyword(Integer uid, String searchKeyword);
}
