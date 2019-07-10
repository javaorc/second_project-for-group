package com.cskaoyan.service.wxGoods;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.goods.GoodsMapper;
import com.cskaoyan.mapper.wxGoods.WxGoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class WxGoodsServiceImpl implements WxGoodsService {
    @Autowired
    WxGoodsMapper wxGoodsMapper;


    @Override
    public Integer queryGoodsCount() {

        return wxGoodsMapper.queryGoodsCounts();
    }

    @Override
    public List<Goods> queryGoodsByBrandId(int brandId) {
        List<Goods> goods = wxGoodsMapper.queryGoodsByBrandId(brandId);
        return goods;
    }

    @Override
    public Goods queryGoodsById(int id) {
        Goods goods = wxGoodsMapper.queryGoodsById(id);
        return goods;
   }

    @Override
    public List<Goods> queryGoodsByCategoryIdAndName(Integer categoryId, String keyword, String sort, String order) {
        return wxGoodsMapper.queryGoodsByCategoryIdAndName(categoryId, keyword, sort, order);
    }
}
