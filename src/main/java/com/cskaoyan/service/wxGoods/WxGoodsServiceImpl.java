package com.cskaoyan.service.wxGoods;

import com.cskaoyan.bean.Goods;
import com.cskaoyan.mapper.wxGoods.WxGoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WxGoodsServiceImpl implements WxGoodsService {
    @Autowired
    WxGoodsMapper wxGoodsMapper;


    @Override
    public Integer queryGoodsCount() {

        return wxGoodsMapper.queryGoodsCounts();
    }

    @Override
    public List<Goods> queryGoodsByCategoryId(int categoryId) {
        List<Goods> goods = wxGoodsMapper.queryGoodsByCategoryId(categoryId);
        return goods;
    }

    @Override
    public List<Goods> queryGoodsByBrandId(int brandId) {
        List<Goods> goods = wxGoodsMapper.queryGoodsByBrandId(brandId);
        return goods;
    }

    @Override
    public List<Goods> queryGoodsByName(String name) {
        List<Goods> goods = wxGoodsMapper.queryGoodsByName(name);
        return goods;
    }
}
