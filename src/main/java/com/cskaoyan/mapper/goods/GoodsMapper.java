package com.cskaoyan.mapper.goods;

import com.cskaoyan.bean.Goods;
import com.cskaoyan.bean.GoodsAttribute;
import com.cskaoyan.bean.GoodsProduct;
import com.cskaoyan.bean.GoodsSpecification;
import com.cskaoyan.bean.vo.Node;
import com.cskaoyan.bean.vo.Node2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    int queryTotalRecords(@Param("goodsSn") String goodsSn, @Param("name") String name);

    List<Goods> queryList(@Param("limit") int limit, @Param("offset") int offset, @Param("sort") String sort, @Param("order") String order, @Param("goodsSn") String goodsSn, @Param("name") String name);

    Goods queryGoodsById(@Param("id") int id);

    List<GoodsAttribute> queryGoodsAttributeByGoodsId(@Param("goodsId") int goodsId);

    List<Integer> queryCategoryIdsByGoodsId(@Param("goodsId") int goodsId);

    List<GoodsSpecification> querySpecificationsByGoodsId(@Param("goodsId") int goodsId);

    List<GoodsProduct> queryProductsByGoodsId(@Param("goodsId") int goodsId);

    int deleteGoodsAttributesByGoodsId(int id);

    int deleteGoodsSpecificationsByGoodsId(int id);

    int deleteGoodsProductsByGoodsId(int id);

    int deleteGoodsByGoodsId(int id);

    int updateGoodsAttribute(@Param("attribute") GoodsAttribute attribute);

    int insertGoodsAttribute(@Param("attribute") GoodsAttribute attribute);

    int updateGoodsSpecification(@Param("specification") GoodsSpecification specification);

    int insertGoodsSpecification(@Param("specification") GoodsSpecification specification);

    int updateGoodsProduct(@Param("product") GoodsProduct product);

    int insertGoodsProduct(@Param("product") GoodsProduct product);

    int updateGoods(@Param("goods") Goods goods);


    /*cat And  brand*/
    List<Node> queryCategoryList();
    List<Node2> queryBrandList();

    int insertGoods(@Param("goods") Goods goods);
}
