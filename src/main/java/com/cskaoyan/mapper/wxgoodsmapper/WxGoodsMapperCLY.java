package com.cskaoyan.mapper.wxgoodsmapper;

import com.cskaoyan.bean.*;
import com.cskaoyan.bean.wxBean.WxGoods2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxGoodsMapperCLY {

    List<WxGoods2> queryRelated(@Param("categoryId") String categoryId);

    String queryCategoryId(@Param("id") String id);

    List<GoodsSpecification> querySpecificationList(@Param("id") String id);

    Issue[] queryIssue();

    GoodsAttribute[] queryAttribute(@Param("id") String id);

    Brand queryBrand(@Param("id") String id);

    List<GoodsProduct> queryProductList(@Param("id")String id);

    Goods queryInfo(@Param("id") String id);

    List<Comment> queryCommentDate(@Param("id") String id);

    Integer queryCommentCount(@Param("id") String id);

}
