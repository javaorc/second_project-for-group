package com.cskaoyan.service.wxGoods;

import com.cskaoyan.bean.Goods;


import java.util.List;
import java.util.Map;

public interface WxGoodsService {
    Integer queryGoodsCount();
    List<Goods> queryGoodsByBrandId(int brandId);
    Goods queryGoodsById(int id);
    List<Goods> queryGoodsByCategoryIdAndName(Integer categoryId, String keyword, String sort, String order);
}
