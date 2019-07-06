package com.cskaoyan.service.goods;

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

    Goods queryGoodsyId(int id);

    Map queryGoodsDeatilById(int id);

    int updateGoods(QueryMapVO queryMapVO);

    Map queryCatAndBrand();

    int insertGoods(QueryMapVO queryMapVO);
}
