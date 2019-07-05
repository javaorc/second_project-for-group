package com.cskaoyan.service;

import com.cskaoyan.bean.Goods;
import com.cskaoyan.bean.GoodsAttribute;
import com.cskaoyan.bean.GoodsProduct;
import com.cskaoyan.bean.GoodsSpecification;
import com.cskaoyan.bean.vo.QueryList;
import com.cskaoyan.bean.vo.QueryMapVO;

import java.util.List;
import java.util.Map;

public interface GoodsService {

    QueryList queryList(int page, int limit, String sort, String order, String goodsSn, String name);

    int deleteGoods(Goods goods);

    Map queryGoodsDeatilById(int id);

    int updateGoods(QueryMapVO queryMapVO);
}
