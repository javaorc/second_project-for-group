package com.cskaoyan.mapper;

import com.cskaoyan.bean.Goods;
import com.cskaoyan.bean.GoodsAttribute;
import com.cskaoyan.bean.GoodsProduct;
import com.cskaoyan.bean.GoodsSpecification;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    int queryTotalRecords(@Param("goodsSn") String goodsSn, @Param("name") String name);

    List<Goods> queryList(@Param("limit") int limit, @Param("offset") int offset, @Param("sort") String sort, @Param("order") String order, @Param("goodsSn") String goodsSn, @Param("name") String name);

    Goods queryGoodsById(@Param("id") int id);

    List<GoodsAttribute> queryGoodsAttributeByGoodsId(@Param("goodsId") int goodsId);

    List<Integer> queryCategoryIdsByGoodsId(@Param("goodsId") int goodsId);

    List<GoodsSpecification> querySpecificationsByGoodsId(@Param("goodsId") int goodsId);

    List<GoodsProduct> queryProductsByGoodsId(@Param("goodsId") int goodsId);
}
