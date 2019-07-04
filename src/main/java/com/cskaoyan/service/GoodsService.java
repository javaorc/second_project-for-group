package com.cskaoyan.service;

import com.cskaoyan.bean.Goods;
import com.cskaoyan.bean.GoodsAttribute;
import com.cskaoyan.bean.GoodsProduct;
import com.cskaoyan.bean.GoodsSpecification;
import com.cskaoyan.bean.vo.QueryList;

import java.util.List;

public interface GoodsService {

    QueryList queryList(int page, int limit, String sort, String order, String goodsSn, String name);

    Goods queryGoodsById(int id);

    List<GoodsAttribute> queryGoodsAttributeByGoodsId(int goodsId);

    List<Integer> queryCategoryIdsByGoodsId(int goodsId);

    List<GoodsSpecification> querySpecificationsByGoodsId(int goodsId);

    List<GoodsProduct> queryProductsByGoodsId(int goodsId);
}
