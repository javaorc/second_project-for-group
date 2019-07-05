package com.cskaoyan.service;
import com.cskaoyan.bean.Keyword;

import java.util.Date;
import java.util.List;


public interface KeywordService {
    List<Keyword> queryAllKeywordList(String keyword,String url);

    int updateKeyword(Integer id, String keyword, String url, boolean isHot, boolean isDefault, Date updateTime);

    int deleteKeyword(Integer id);

    int queryKeywordByKeywordAndUrl(String keyword,String url);

    int insertKeyword(Keyword keyword);
}
