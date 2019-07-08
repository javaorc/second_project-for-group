package com.cskaoyan.controller.generalize;

import com.cskaoyan.bean.Goods;
import com.cskaoyan.bean.Groupon;
import com.cskaoyan.bean.GrouponRules;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.goods.GoodsService;
import com.cskaoyan.service.generalize.GrouponRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/5 15:52
 **/
@Controller
@RequestMapping("admin")
public class GrouponRulesController {

    @Autowired
    GrouponRulesService grouponRulesService;
    @Autowired
    GoodsService goodsService;

    @RequestMapping("groupon/list")
    @ResponseBody
    public ResponseVO<Map<String, Object>> grouponList(Integer goodsId,
                                                       int page, int limit, String sort, String order) {
        return grouponRulesService.grouponList(goodsId,page,limit);
    }

    @RequestMapping("groupon/update")
    @ResponseBody
    public ResponseVO<GrouponRules> updateGrouponRules(@RequestBody GrouponRules grouponRules) {
        ResponseVO<GrouponRules> grouponRulesResponseVO = new ResponseVO<>();
        grouponRulesResponseVO.setErrmsg("成功");
        grouponRulesResponseVO.setErrno(0);
        grouponRules.setUpdateTime(new Date());
        int i = grouponRulesService.updateGrouponRules(grouponRules);
        if (i == 1) {
            //grouponRulesResponseVO.setData(grouponRules);
            return grouponRulesResponseVO;
        }
        return null;
    }

    @RequestMapping("groupon/delete")
    @ResponseBody
    public ResponseVO<Object> deleteGrouponRules(@RequestBody GrouponRules grouponRules) {
        ResponseVO<Object> responseVO = new ResponseVO<>();
        int i = grouponRulesService.deleteGrouponRules(grouponRules);
        if (i == 1) {
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
            return responseVO;
        }
        return null;
    }

    @RequestMapping("groupon/create")
    @ResponseBody
    public ResponseVO<GrouponRules> createGrouponRules(@RequestBody GrouponRules grouponRules) {
        //根据goodsid 查出相应的商品信息 将这些信息赋值给grules ，再插入和返回
        ResponseVO<GrouponRules> grouponRulesResponseVO = new ResponseVO<>();
        Goods goods = goodsService.queryGoodsById(grouponRules.getGoodsId());
        if (goods == null) {
            grouponRulesResponseVO.setErrmsg("参数值不对");
            grouponRulesResponseVO.setErrno(402);
            return grouponRulesResponseVO;
        }
            Date date = new Date();
            grouponRules.setAddTime(date);
            grouponRules.setUpdateTime(date);
            grouponRules.setGoodsName(goods.getName());
            grouponRules.setPicUrl(goods.getPicUrl());
            grouponRules.setDeleted(false);
            int i = grouponRulesService.insertGrouponRules(grouponRules);
            if (i == 1) {
                grouponRulesResponseVO.setErrmsg("成功");
                grouponRulesResponseVO.setErrno(0);
                grouponRulesResponseVO.setData(grouponRules);
                return grouponRulesResponseVO;
            }

        return null;
    }

    @RequestMapping("groupon/listRecord")
    @ResponseBody
    public ResponseVO<Map<Object,Object>> listRecord(Integer goodsId,
                                                     int page, int limit, String sort, String order){
        ResponseVO<Map<Object,Object>> responseVO = new ResponseVO<>();
        Map<Object, Object> datamap = new HashMap<>();
        Map<Object, Object> map = new HashMap<>();
        List<Map<Object,Object>> items = new ArrayList<>();
        List<Groupon> grouponList = grouponRulesService.queryGrouponAndRulesAndGoods(goodsId);
        for(Groupon groupon:grouponList){
            //根据groupon 将数据put 进map
            //Rules rules = groupon.getRules();
            GrouponRules rules = groupon.getRules();
            Goods goods = rules.getGoods();
            map.put("goods",goods);
            map.put("groupon",groupon);
            map.put("rules",rules);
            map.put("subGroupons","");
            items.add(map);
        }
        datamap.put("items",items);
        datamap.put("total",items.size());
        responseVO.setData(datamap);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return  responseVO;
    }

}
