package com.cskaoyan.mapper.wxSearch;

import com.cskaoyan.bean.Keyword;
import com.cskaoyan.bean.wxBean.WxSearchKeyword;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxSearchMapper {
    Keyword queryDefaultKeyword();

    List<WxSearchKeyword> queryHistoryKeywordList(@Param("uid") int uid);

    List<Keyword> queryHotKeywordList();

    int clearHistoryKeyword(@Param("uid") int uid);

    int insertSearchKeyword(@Param("searchKeyword") WxSearchKeyword searchKeyword);

    int isExist(@Param("uid") int uid, @Param("keyword") String keyword);
}
