package com.cskaoyan.mapper.wxGoods;

import com.cskaoyan.bean.History;
import org.apache.ibatis.annotations.Param;

public interface WxSearchHistoryMapper {
    void addSearchHistory(@Param("history") History history);
}
