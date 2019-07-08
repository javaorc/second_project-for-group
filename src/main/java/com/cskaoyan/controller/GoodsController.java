package com.cskaoyan.controller;

import com.cskaoyan.bean.*;
import com.cskaoyan.bean.vo.QueryList;
import com.cskaoyan.bean.vo.QueryMapVO;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.bean.vo.ResponseVO2;
import com.cskaoyan.service.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    /*获取列表*/
    /*精确查询商品编号*/
    /*模糊查询商品名称*/
    @RequestMapping("admin/goods/list")
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
    @RequestMapping("admin/goods/catAndBrand")
    @ResponseBody
    public ResponseVO<Map> queryCatAndBrand() {

        ResponseVO<Map> responseVO = new ResponseVO<>();

        Map map = goodsService.queryCatAndBrand();

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

        Map map = goodsService.queryGoodsDetailById(id);

        responseVO.setData(map);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

    /*删除商品*/
    @RequestMapping("admin/goods/delete")
    @ResponseBody
    public ResponseVO2 delete(@RequestBody Goods goods) {

        ResponseVO2 responseVO2 = new ResponseVO2();
        int ret = goodsService.deleteGoods(goods);

        if(ret == 1) {
            responseVO2.setErrmsg("成功");
            responseVO2.setErrno(0);
        } else {
            responseVO2.setErrmsg("失败");
            responseVO2.setErrno(-1);
        }
        return responseVO2;
    }

    /*更新商品信息*/
    @RequestMapping("admin/goods/update")
    @ResponseBody
    public ResponseVO2 update(@RequestBody QueryMapVO queryMapVO) {
        ResponseVO2 responseVO2 = new ResponseVO2();

        int ret = goodsService.updateGoods(queryMapVO);

        if (ret == 1) {
            responseVO2.setErrmsg("成功");
            responseVO2.setErrno(0);
        } else {
            responseVO2.setErrmsg("失败");
            responseVO2.setErrno(-2);
        }
        return responseVO2;
    }

    /*添加商品*/
    @RequestMapping("admin/goods/create")
    @ResponseBody
    public ResponseVO2 add(@RequestBody QueryMapVO queryMapVO) {

        ResponseVO2 responseVO2 = new ResponseVO2();

        int ret = goodsService.insertGoods(queryMapVO);
        if (ret == 1) {
            responseVO2.setErrmsg("成功");
            responseVO2.setErrno(0);
        } else {
            responseVO2.setErrmsg("失败");
            responseVO2.setErrno(-3);
        }
        return responseVO2;
    }

    /*查询商品总数*/
    @RequestMapping("wx/goods/count")
    @ResponseBody
    public ResponseVO<Map> count() {
        ResponseVO<Map> responseVO = new ResponseVO<>();
        Map<String, Object> map = new HashMap<>();

        map.put("goodsCount", goodsService.queryTotalRecords());

        responseVO.setData(map);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }
}
