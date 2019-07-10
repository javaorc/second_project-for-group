package com.cskaoyan.service.wxgroupon;

import com.cskaoyan.bean.Feedback;
import com.cskaoyan.bean.GrouponRules;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.bean.wxgrouponrela.FootPrintBean;
import com.cskaoyan.bean.wxgrouponrela.GrouponDetail;
import com.cskaoyan.bean.wxgrouponrela.GrouponMy;
import com.cskaoyan.bean.wxgrouponrela.OrderInfo;
import com.cskaoyan.mapper.wxgroupon.WxGrouponMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/8 15:43
 **/
@Service
public class WxGrouponServiceImpl implements WxGrouponService {

    @Autowired
    WxGrouponMapper wxGrouponMapper;

    ResponseVO<Map<String, Object>> mapResponseVO = new ResponseVO<>();

    Map<String, Object> map = new HashMap<>();

    int i=1;

    @Override
    public ResponseVO<Map<String, Object>> gouponList(int page, int size) {
        List<GrouponRules> grouponRulesList = wxGrouponMapper.gouponList();
        for (GrouponRules grouponRules : grouponRulesList) {
            grouponRules.setGroupon_member(grouponRules.getDiscountMember());
            grouponRules.setGroupon_price((int) (grouponRules.getGoods().getCounterPrice()
                    - grouponRules.getDiscount()));
        }
        PageHelper.startPage(page, size);
        PageInfo<GrouponRules> couponPageInfo = new PageInfo<>(grouponRulesList);
        map.put("count", couponPageInfo.getTotal());
        map.put("data", grouponRulesList);
        mapResponseVO.setData(map);
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setErrno(0);
        return mapResponseVO;
    }

    @Override
    public ResponseVO<Map<String, Object>> gouponMy(Integer showType) {
        if(showType==1){
            map.put("data","");
            map.put("count",0);
            mapResponseVO.setData(map);
            mapResponseVO.setErrmsg("成功");
            mapResponseVO.setErrno(0);
            return mapResponseVO;
        }
        List<GrouponMy> grouponMyList = wxGrouponMapper.grouponMy(showType);
        for (GrouponMy grouponMy : grouponMyList) {
            grouponMy.setId(grouponMy.getGroupon().getId());
            grouponMy.setGoodsList(new int[] {});
            grouponMy.setJoinerCount(1);
            grouponMy.setIsCreator(true);
            Integer orderStatus = grouponMy.getOrderStatus();
            if (orderStatus == 101) {
                grouponMy.setOrderStatusText("订单生成，未支付");
            } else if (orderStatus == 102) {
                grouponMy.setOrderStatusText("下单后未支付用户取消");
            } else if (orderStatus == 103) {
                grouponMy.setOrderStatusText("下单后超时系统自动取消");
            } else if (orderStatus == 201) {
                grouponMy.setOrderStatusText("支付完成商家未发货");
            } else if (orderStatus == 202) {
                grouponMy.setOrderStatusText("已付款未发货，用户取消");
            } else if (orderStatus == 301) {
                grouponMy.setOrderStatusText("商家发货，用户未确认");
            } else if (orderStatus == 401) {
                grouponMy.setOrderStatusText("用户确认收货");
            } else if (orderStatus == 402) {
                grouponMy.setOrderStatusText("超时系统自动确认收货");
            }
        }
        map.put("count", grouponMyList.size());
        map.put("data", grouponMyList);
        mapResponseVO.setData(map);
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setErrno(0);
        return mapResponseVO;
    }

    @Override
    public ResponseVO<Map<String, Object>> gouponDetail(Integer grouponId) {
        Map<String, Object> map = new HashMap<>();
        GrouponDetail grouponDetail =wxGrouponMapper.queryGrouponDetailByGrouponId(grouponId);
        OrderInfo orderInfo = grouponDetail.getOrderInfo();
        int orderStatus = orderInfo.getOrderStatus();

        if (orderStatus == 101) {
            orderInfo.setOrderStatusText("订单生成，未支付");
        } else if (orderStatus == 102) {
            orderInfo.setOrderStatusText("下单后未支付用户取消");
        } else if (orderStatus == 103) {
            orderInfo.setOrderStatusText("下单后超时系统自动取消");
        } else if (orderStatus == 201) {
            orderInfo.setOrderStatusText("支付完成商家未发货");
        } else if (orderStatus == 202) {
            orderInfo.setOrderStatusText("已付款未发货，用户取消");
        } else if (orderStatus == 301) {
            orderInfo.setOrderStatusText("商家发货，用户未确认");
        } else if (orderStatus == 401) {
            orderInfo.setOrderStatusText("用户确认收货");
        } else if (orderStatus == 402) {
            orderInfo.setOrderStatusText("超时系统自动确认收货");
        }
        map.put("creator",grouponDetail.getCreator());
        map.put("groupon",grouponDetail.getGroupon());
        map.put("joiners",grouponDetail.getJoiners());
        map.put("linkGrouponId",1);
        map.put("orderGoods",new int[] {});
        map.put("rules",grouponDetail.getGrouponRules());
        map.put("orderInfo",grouponDetail.getOrderInfo());
        mapResponseVO.setData(map);
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setErrno(0);
        return mapResponseVO;
    }

    @Override
    public ResponseVO<Map<String, Object>> feedback( Map<String,Object> map) {
        Feedback feedback =new Feedback();
        String content = (String) map.get("content");
        feedback.setContent(content);
        feedback.setFeedType((String) map.get("feedType"));
        feedback.setHasPicture((Boolean) map.get("hasPicture"));
        feedback.setMobile((String) map.get("mobile"));
        /*List<String> picUrls = (List<String>) map.get("picUrls");
        feedback.setPicUrls(picUrls);*/
        int i = wxGrouponMapper.feedback(feedback);
        if(i==1){
            map=null;
            mapResponseVO.setData(map);
            mapResponseVO.setErrmsg("成功");
            mapResponseVO.setErrno(0);
        }
        return mapResponseVO;
    }

    @Override
    public ResponseVO<Map<String, Object>> footprint(Integer page, Integer size) {
        List<FootPrintBean> footPrintBeanList = wxGrouponMapper.footprint();

        PageHelper.startPage(page,size);
        PageInfo<FootPrintBean> footPrintBeanPageInfo = new PageInfo<>(footPrintBeanList);
        map.put("footprintList",footPrintBeanList);
        map.put("totalPages",footPrintBeanPageInfo.getTotal());
        mapResponseVO.setData(map);
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setErrno(0);
        return mapResponseVO;
    }
}
