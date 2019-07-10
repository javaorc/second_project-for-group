package com.cskaoyan.service.wxgoodsservice;

import com.cskaoyan.bean.Footprint;
import com.cskaoyan.bean.Goods;
import com.cskaoyan.bean.vo.GoodsQuery;
import com.cskaoyan.bean.wxBean.WxComment;
import com.cskaoyan.bean.wxBean.WxComment3;
import com.cskaoyan.bean.wxBean.WxGoods2;
import com.cskaoyan.bean.wxBean.WxGoodsSpecification;
import com.cskaoyan.mapper.wxgoodsmapper.WxGoodsMapperCLY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WxGoodsServiceImplCLY implements WxGoodsServiceCLY {

    @Autowired
    WxGoodsMapperCLY wxGoodsMapperCLY;

    @Override
    public GoodsQuery getDetail(String id) {

        GoodsQuery goodsQuery = new GoodsQuery();

        WxGoodsSpecification wxGoodsSpecification = new WxGoodsSpecification();
        wxGoodsSpecification.setName("规格");
        wxGoodsSpecification.setValueList(wxGoodsMapperCLY.querySpecificationList(id));
        List<WxGoodsSpecification> list = new ArrayList<>();
        list.add(wxGoodsSpecification);
        goodsQuery.setSpecificationList(list);

        goodsQuery.setIssue(wxGoodsMapperCLY.queryIssue());

        goodsQuery.setUserHasCollect(0);

        goodsQuery.setShareImage("");

        WxComment<WxComment3> wxComment = new WxComment<>();
        wxComment.setData(wxGoodsMapperCLY.queryCommentDate(id));
        wxComment.setCount(wxGoodsMapperCLY.queryCommentCount(id));
        goodsQuery.setComment(wxComment);

        goodsQuery.setGroupon(wxGoodsMapperCLY.queryGroupon(id));

        goodsQuery.setAttribute(wxGoodsMapperCLY.queryAttribute(id));

        goodsQuery.setBrand(wxGoodsMapperCLY.queryBrand(id));

        goodsQuery.setProductList(wxGoodsMapperCLY.queryProductList(id));

        goodsQuery.setInfo(wxGoodsMapperCLY.queryInfo(id));
        return goodsQuery;
    }

    @Override
    public List<WxGoods2> getRelated(String id) {
        return wxGoodsMapperCLY.queryRelated(wxGoodsMapperCLY.queryCategoryId(id));
    }

    @Override
    public Goods queryGoodsById(String id) {
        return wxGoodsMapperCLY.queryGoodsById(id);
    }

    @Override
    public void insertFootprint(Footprint footPrintBean) {
         wxGoodsMapperCLY.insertFootprint(footPrintBean);
    }

}
