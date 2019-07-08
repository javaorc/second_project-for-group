package com.cskaoyan.service.wxgroupon;

import com.cskaoyan.bean.GrouponRules;
import com.cskaoyan.bean.vo.ResponseVO;
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
}
