package com.cskaoyan.mapper;

import com.cskaoyan.bean.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {

    int queryTotalRecords(@Param("goodsSn") String goodsSn, @Param("name") String name);

    List<Goods> queryList(@Param("limit") int limit, @Param("offset") int offset, @Param("sort") String sort, @Param("order") String order, @Param("goodsSn") String goodsSn, @Param("name") String name);
}
