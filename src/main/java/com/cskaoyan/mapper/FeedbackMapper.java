package com.cskaoyan.mapper;

import com.cskaoyan.bean.Feedback;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FeedbackMapper {

    List<Feedback> queryList(@Param("limit") int limit,
                             @Param("offset") int offset,
                             @Param("sort") String sort,
                             @Param("order") String order,
                             @Param("username") String username,
                             @Param("id") String id);

    int queryTotal(@Param("username") String username,
                   @Param("id") String id);
}
