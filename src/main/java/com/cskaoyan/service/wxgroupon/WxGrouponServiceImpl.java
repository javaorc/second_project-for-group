package com.cskaoyan.service.wxgroupon;

import com.cskaoyan.bean.GrouponRules;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.bean.wxgrouponrela.GrouponMy;
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
}
