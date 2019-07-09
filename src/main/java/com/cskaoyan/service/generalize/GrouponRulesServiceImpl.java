package com.cskaoyan.service.generalize;

import com.cskaoyan.bean.Groupon;
import com.cskaoyan.bean.GrouponRules;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.bean.wxBean.WxGroupon;
import com.cskaoyan.mapper.generalize.GrouponRulesMapper;
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
 * @CreateTime 2019/7/5 15:55
 **/
@Service
public class GrouponRulesServiceImpl implements GrouponRulesService {
    @Autowired
    GrouponRulesMapper grouponRulesMapper;

    ResponseVO<Map<String, Object>> mapResponseVO = new ResponseVO<>();

    Map<String, Object> map = new HashMap<>();

    @Override
    public ResponseVO<Map<String, Object>> grouponList(Integer goodsId,int page,int limit) {
        if("".equals(goodsId)){
            goodsId=null;
        }
        List<GrouponRules> grouponRulesList = grouponRulesMapper.grouponList(goodsId);
        //分页
        PageHelper.startPage(page,limit);
        PageInfo<GrouponRules> grouponRulesPageInfo = new PageInfo<>(grouponRulesList);
        map.put("total", grouponRulesPageInfo.getTotal());
        map.put("items", grouponRulesList);
        //封装
        mapResponseVO.setData(map);
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setErrno(0);

        return mapResponseVO;
    }

    @Override
    public int updateGrouponRules(GrouponRules grouponRules) {
        return grouponRulesMapper.updateGrouponRules(grouponRules);
    }

    @Override
    public int deleteGrouponRules(GrouponRules grouponRules) {
        return grouponRulesMapper.deleteGrouponRules(grouponRules);
    }

    @Override
    public int insertGrouponRules(GrouponRules grouponRules) {
        return grouponRulesMapper.insertGrouponRules(grouponRules);
    }

    @Override
    public List<Groupon> queryGrouponAndRulesAndGoods(Integer goodsId) {
        return grouponRulesMapper.queryGrouponAndRulesAndGoods(goodsId);
    }

    @Override
    public List<WxGroupon> queryGrouponRules() {
        return grouponRulesMapper.queryGrouponRules();
    }
}
