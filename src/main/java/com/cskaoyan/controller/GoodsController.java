package com.cskaoyan.controller;

import com.cskaoyan.bean.Brand;
import com.cskaoyan.bean.Category;
import com.cskaoyan.bean.Goods;
import com.cskaoyan.bean.vo.QueryList;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("admin")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    /*获取列表*/
    /*精确查询商品编号*/
    /*模糊查询商品名称*/
    @RequestMapping("goods/list")
    @ResponseBody
    public ResponseVO<QueryList> queryList(int page, int limit, String sort, String order, String goodsSn, String name) {
        ResponseVO<QueryList> responseVO = new ResponseVO<>();

        if ("".equals(goodsSn))
            goodsSn = null;

        if ("".equals(name))
            name = null;

        QueryList queryList = goodsService.queryList(page, limit, sort, order, goodsSn, name);

        responseVO.setData(queryList);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);

        return responseVO;
    }

    /*查询所有分类*/
    /*查询所有品牌商*/
    @RequestMapping("goods/catAndBrand")
    @ResponseBody
    public ResponseVO<Map> queryCatAndBrand() {

        ResponseVO<Map> responseVO = new ResponseVO<>();
        Map<String, Object> map = new HashMap<>();

        List categoryList = null;
        List brandList = null;

        map.put("categoryList", categoryList);
        map.put("brandList", brandList);

        responseVO.setData(map);
        responseVO.setErrno(0);
        responseVO.setErrmsg("成功");
        return responseVO;
    }

    /*获取商品的详情*/
    @RequestMapping("goods/detail")
    @ResponseBody
    public ResponseVO<Map> detail(int id) {

        ResponseVO<Map> responseVO = new ResponseVO<>();
        Map<String, Object> map = new HashMap<>();

        map.put("goods", goodsService.queryGoodsById(id));
        map.put("attributes", goodsService.queryGoodsAttributeByGoodsId(id));
        map.put("categoryIds", goodsService.queryCategoryIdsByGoodsId(id));
        map.put("products", goodsService.queryProductsByGoodsId(id));
        map.put("specifications", goodsService.querySpecificationsByGoodsId(id));

        responseVO.setData(map);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }
}
