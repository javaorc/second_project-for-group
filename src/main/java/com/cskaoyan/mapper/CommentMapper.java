package com.cskaoyan.mapper;

import com.cskaoyan.bean.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {

    void deleteOne(@Param("comment") Comment comment);

    List<Comment> queryList(@Param("limit") int limit,
                            @Param("offset") int offset,
                            @Param("sort") String sort,
                            @Param("order") String order,
                            @Param("userId") String userId,
                            @Param("valueId") String valueId);

    int queryTotal(@Param("userId") String userId,
                   @Param("valueId") String valueId);

}


