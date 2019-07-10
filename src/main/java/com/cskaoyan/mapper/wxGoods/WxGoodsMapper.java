package com.cskaoyan.mapper.wxGoods;

import com.cskaoyan.bean.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxGoodsMapper {
    Integer queryGoodsCounts();
    List<Goods> queryGoodsByBrandId(@Param("brandId")int brandId);
    Goods queryGoodsById(@Param("id")int id);

    List<Goods> queryGoodsByCategoryIdAndName(@Param("categoryId") int categoryId, @Param("keyword") String keyword, @Param("sort") String sort, @Param("order") String order);
}
