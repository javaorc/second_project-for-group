package com.cskaoyan.service;

import com.cskaoyan.bean.Goods;
import com.cskaoyan.bean.GoodsAttribute;
import com.cskaoyan.bean.GoodsProduct;
import com.cskaoyan.bean.GoodsSpecification;
import com.cskaoyan.bean.vo.QueryList;
import com.cskaoyan.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public QueryList queryList(int page, int limit, String sort, String order, String goodsSn, String name) {

        int total = goodsMapper.queryTotalRecords(goodsSn, name);
        int offset = (page - 1) * limit;
        List<Goods> items = goodsMapper.queryList(limit, offset, sort, order, goodsSn, name);

        QueryList queryList = new QueryList();

        queryList.setTotal(total);
        queryList.setItems(items);

        return queryList;
    }

    @Override
    public Goods queryGoodsById(int id) {
        return goodsMapper.queryGoodsById(id);
    }

    @Override
    public List<GoodsAttribute> queryGoodsAttributeByGoodsId(int goodsId) {
        return goodsMapper.queryGoodsAttributeByGoodsId(goodsId);
    }

    @Override
    public List<Integer> queryCategoryIdsByGoodsId(int goodsId) {
        return goodsMapper.queryCategoryIdsByGoodsId(goodsId);
    }

    @Override
    public List<GoodsSpecification> querySpecificationsByGoodsId(int goodsId) {
        return goodsMapper.querySpecificationsByGoodsId(goodsId);
    }

    @Override
    public List<GoodsProduct> queryProductsByGoodsId(int goodsId) {
        return goodsMapper.queryProductsByGoodsId(goodsId);
    }
}
