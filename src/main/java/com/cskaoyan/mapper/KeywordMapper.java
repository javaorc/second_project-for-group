package com.cskaoyan.mapper;
import com.cskaoyan.bean.Keyword;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface KeywordMapper {

    List<Keyword> queryAllKeywordList(@Param("keyword") String keyword,@Param("url")String url);

    int	queryKeywordByKeywordAndUrl(@Param("keyword") String keyword,@Param("url")String url);

    int insertKeyword(@Param("keyword") Keyword keyword);

    int deleteKeyword(Integer id);

    int updateKeyword(@Param("id") Integer id, @Param("keyword") String keyword, @Param("url")String url, @Param("isHot")boolean isHot, @Param("isDefault")boolean isDefault, @Param("updateTime")Date updateTime);
}
