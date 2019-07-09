package com.cskaoyan.service.wxGoods;

import com.cskaoyan.bean.Goods;


import java.util.List;

public interface WxGoodsService {
    Integer queryGoodsCount();
    List<Goods> queryGoodsByCategoryId(int categoryId);
}
