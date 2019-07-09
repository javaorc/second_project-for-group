package com.cskaoyan.service.wxgoodsservice;

import com.cskaoyan.bean.vo.GoodsQuery;
import com.cskaoyan.bean.wxBean.WxGoods2;

import java.util.List;

public interface WxGoodsServiceCLY {

    GoodsQuery getDetail(String id);

    List<WxGoods2> getRelated(String id);

}
