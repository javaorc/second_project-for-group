package com.cskaoyan.mapper.wxGoods;

import com.cskaoyan.bean.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxGoodsMapper {
    Integer queryGoodsCounts();
    List<Goods> queryGoodsByCategoryId(@Param("categoryId")int categoryId);
}
