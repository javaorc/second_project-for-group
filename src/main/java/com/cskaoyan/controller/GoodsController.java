package com.cskaoyan.controller;

import com.cskaoyan.OperationLog.OperationLog;
import com.cskaoyan.bean.*;
import com.cskaoyan.bean.vo.QueryList;
import com.cskaoyan.bean.vo.QueryMapVO;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.bean.vo.ResponseVO2;
import com.cskaoyan.service.SystemService;
import com.cskaoyan.service.goods.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@Api(tags = "商品管理",description = "GoodsController是商品管理的Controller")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    SystemService systemService;

    /*获取列表*/
    /*精确查询商品编号*/
    /*模糊查询商品名称*/
    @RequestMapping("admin/goods/list")
    @ResponseBody
    @ApiOperation(value = "queryGoodsList",notes = "商品列表的展示以及查找功能")
    @RequiresPermissions(value = "admin:goods:list")
    public ResponseVO<QueryList> queryGoodsList(int page, int limit, String sort, String order, String goodsSn, String name) {
        ResponseVO<QueryList> responseVO = new ResponseVO<>();

        if ("".equals(goodsSn))
            goodsSn = null;

        if ("".equals(name))
            name = null;

        QueryList queryList = goodsService.queryList(page, limit, sort, order, goodsSn, name);

        responseVO.setData(queryList);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);

        String opName = (String) SecurityUtils.getSubject().getPrincipal();
        OperationLog operationLog=new OperationLog();
        operationLog.logInsert(systemService,"获取商品列表",opName);
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
    @RequestMapping("admin/goods/detail")
    @ResponseBody
    @ApiOperation(value = "editGoods",notes = "商品列表的编辑功能")
    @RequiresPermissions(value = "admin:goods:read")
    public ResponseVO<Map> editGoods(int id) {
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
    @ApiOperation(value = "deleteGoods",notes = "商品管理的删除功能")
    @RequiresPermissions(value = "admin:goods:delete")
    public ResponseVO2 deleteGoods(@RequestBody Goods goods) {

        ResponseVO2 responseVO2 = new ResponseVO2();
        int ret = goodsService.deleteGoods(goods);

        if(ret == 1) {
            responseVO2.setErrmsg("成功");
            responseVO2.setErrno(0);
        } else {
            responseVO2.setErrmsg("失败");
            responseVO2.setErrno(-1);
        }

        String name = (String) SecurityUtils.getSubject().getPrincipal();
        OperationLog operationLog=new OperationLog();
        operationLog.logInsert(systemService,"删除商品",name);
        return responseVO2;
    }

    /*更新商品信息*/
    @RequestMapping("admin/goods/update")
    @ResponseBody
    @ApiOperation(value = "updateGoods",notes = "商品管理的更新功能")
    @RequiresPermissions(value = "admin:goods:update")
    public ResponseVO2 updateGoods(@RequestBody QueryMapVO queryMapVO) {
        ResponseVO2 responseVO2 = new ResponseVO2();

        int ret = goodsService.updateGoods(queryMapVO);

        if (ret == 1) {
            responseVO2.setErrmsg("成功");
            responseVO2.setErrno(0);
        } else {
            responseVO2.setErrmsg("失败");
            responseVO2.setErrno(-2);
        }
        String name = (String) SecurityUtils.getSubject().getPrincipal();
        OperationLog operationLog=new OperationLog();
        operationLog.logInsert(systemService,"更新商品",name);
        return responseVO2;
    }

    /*添加商品*/
    @RequestMapping("admin/goods/create")
    @ResponseBody
    @ApiOperation(value = "addGoods",notes = "商品管理的添加功能")
    @RequiresPermissions(value = "admin:goods:create")
    public ResponseVO2 addGoods(@RequestBody QueryMapVO queryMapVO) {

        ResponseVO2 responseVO2 = new ResponseVO2();

        int ret = goodsService.insertGoods(queryMapVO);
        if (ret == 1) {
            responseVO2.setErrmsg("成功");
            responseVO2.setErrno(0);
        } else {
            responseVO2.setErrmsg("失败");
            responseVO2.setErrno(-3);
        }
        String name = (String) SecurityUtils.getSubject().getPrincipal();
        OperationLog operationLog=new OperationLog();
        operationLog.logInsert(systemService,"添加商品",name);
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
