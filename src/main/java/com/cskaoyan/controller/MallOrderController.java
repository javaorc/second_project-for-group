package com.cskaoyan.controller;

import com.cskaoyan.OperationLog.OperationLog;
import com.cskaoyan.bean.Kind;
import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.OrderCGoods;
import com.cskaoyan.bean.OrderGoods;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.mapper.mallManege.MallOrderMapper;
import com.cskaoyan.service.SystemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
@Api(tags = "商场订单",description = "MallIssueController是商场模块订单部分的Controller")
public class MallOrderController {
    @Autowired(required = false)
    MallOrderMapper mallOrderMapper;
    @Autowired
    SystemService systemService;
    @RequestMapping("order/list")
    @ResponseBody
    @RequiresPermissions(value = "admin:storage:list")
    @ApiOperation(value = "createOrder",notes = "订单显示")
    public ResponseVO<Map<String,Object>> createOrder(Integer page,Integer limit,Integer orderStatusArray,Integer userId,String orderSn) {
        PageHelper.startPage(page,limit);
        Map<String, Object> map = new HashMap<>();
        if(orderStatusArray==null&&orderSn==null&&userId==null) {
            List<Order> orders = mallOrderMapper.showAllOrder();
            PageInfo<Order> orderPageInfo = new PageInfo<>(orders);
            map.put("items", orders);
            map.put("total", orderPageInfo.getTotal());

        }else{
            List<Order> orders = mallOrderMapper.searchOrderByInfo(orderStatusArray, userId, orderSn);
            PageInfo<Order> orderPageInfo = new PageInfo<>(orders);
            map.put("items", orders);
            map.put("total", orderPageInfo.getTotal());
        }
        String name1 = (String) SecurityUtils.getSubject().getPrincipal();
        OperationLog operationLog=new OperationLog();
        operationLog.logInsert(systemService,"显示对象",name1);
        ResponseVO<Map<String, Object>> responseVO = new ResponseVO<>();
        responseVO.setData(map);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;

    }

    @RequestMapping("order/detail")
    @ResponseBody
    @RequiresPermissions(value = "admin:storage:list")
    @ApiOperation(value = "showOrderDetail",notes = "订单详情显示")
    public ResponseVO<Map<String,Object>> showOrderDetail(Integer id) {
        Map<String, Object> map = new HashMap<>();
        OrderCGoods orderCGoods = mallOrderMapper.searchOrderGoods(id);
        System.out.println(orderCGoods);
        Object[] objects = orderCGoods.getOrderGoods().toArray();
        ResponseVO<Map<String, Object>> responseVO = new ResponseVO<>();
        map.put("order",orderCGoods);
        map.put("orderGoods",objects);
        map.put("user",orderCGoods.getUser());
        String name1 = (String) SecurityUtils.getSubject().getPrincipal();
        OperationLog operationLog=new OperationLog();
        operationLog.logInsert(systemService,"显示对象",name1);
        responseVO.setData(map);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;

    }




}
