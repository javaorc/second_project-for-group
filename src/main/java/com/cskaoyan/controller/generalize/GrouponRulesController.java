package com.cskaoyan.controller.generalize;

import com.cskaoyan.OperationLog.OperationLog;
import com.cskaoyan.bean.Goods;
import com.cskaoyan.bean.Groupon;
import com.cskaoyan.bean.GrouponRules;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.SystemService;
import com.cskaoyan.service.goods.GoodsService;
import com.cskaoyan.service.generalize.GrouponRulesService;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/5 15:52
 **/
@RestController
@RequestMapping("admin")
@Api(tags = "团购规则",description = "GrouponRulesController是推广管理模块中团购规则模块的Controller")
public class GrouponRulesController {

    @Autowired
    GrouponRulesService grouponRulesService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    SystemService systemService;

    @RequestMapping("groupon/list")
    @RequiresPermissions(value = "admin:groupon:list")
    public ResponseVO<Map<String, Object>> grouponList(Integer goodsId,
                                                       int page, int limit, String sort, String order) {
        return grouponRulesService.grouponList(goodsId,page,limit);
    }

    @RequestMapping("groupon/update")
    @RequiresPermissions(value = "admin:groupon:update")
    public ResponseVO<GrouponRules> updateGrouponRules(@RequestBody GrouponRules grouponRules) {
        ResponseVO<GrouponRules> grouponRulesResponseVO = new ResponseVO<>();
        grouponRulesResponseVO.setErrmsg("成功");
        grouponRulesResponseVO.setErrno(0);
        grouponRules.setUpdateTime(new Date());
        int i = grouponRulesService.updateGrouponRules(grouponRules);
        if (i == 1) {
            //grouponRulesResponseVO.setData(grouponRules);
            String name = (String) SecurityUtils.getSubject().getPrincipal();
            OperationLog operationLog=new OperationLog();
            operationLog.logInsert(systemService,"修改团购规则",name);
            return grouponRulesResponseVO;
        }
        return null;
    }

    @RequestMapping("groupon/delete")
    @RequiresPermissions(value = "admin:groupon:delete")
    public ResponseVO<Object> deleteGrouponRules(@RequestBody GrouponRules grouponRules) {
        ResponseVO<Object> responseVO = new ResponseVO<>();
        int i = grouponRulesService.deleteGrouponRules(grouponRules);
        if (i == 1) {
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
            String name = (String) SecurityUtils.getSubject().getPrincipal();
            OperationLog operationLog=new OperationLog();
            operationLog.logInsert(systemService,"delete团购",name);
            return responseVO;
        }
        return null;
    }

    @RequestMapping("groupon/create")
    @RequiresPermissions(value = "admin:groupon:create")
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
                String name = (String) SecurityUtils.getSubject().getPrincipal();
                OperationLog operationLog=new OperationLog();
                operationLog.logInsert(systemService,"create团购",name);
                return grouponRulesResponseVO;
            }

        return null;
    }

    @RequestMapping("groupon/listRecord")
    @RequiresPermissions(value = "admin:groupon:list")
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
            map.put("subGroupons",new int[] {});
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
