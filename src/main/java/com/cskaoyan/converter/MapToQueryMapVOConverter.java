package com.cskaoyan.converter;

import com.cskaoyan.bean.Goods;
import com.cskaoyan.bean.GoodsAttribute;
import com.cskaoyan.bean.GoodsProduct;
import com.cskaoyan.bean.GoodsSpecification;
import com.cskaoyan.bean.vo.QueryMapVO;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.Map;

public class MapToQueryMapVOConverter implements Converter<Map, QueryMapVO> {
    @Override
    public QueryMapVO convert(Map map) {

        QueryMapVO queryMapVO = new QueryMapVO();
        queryMapVO.setAttributes((List<GoodsAttribute>) map.get("attributes"));
        queryMapVO.setSpecifications((List<GoodsSpecification>) map.get("specifications"));
        queryMapVO.setProducts((List<GoodsProduct>) map.get("products"));
        queryMapVO.setGoods((Goods) map.get("goods"));

        return queryMapVO;
    }
}
