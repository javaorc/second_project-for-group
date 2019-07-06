package com.cskaoyan.service.generalize;

import com.cskaoyan.bean.Groupon;
import com.cskaoyan.bean.GrouponRules;
import com.cskaoyan.mapper.generalize.GrouponRulesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/5 15:55
 **/
@Service
public class GrouponRulesServiceImpl implements GrouponRulesService {
    @Autowired
    GrouponRulesMapper grouponRulesMapper;
    @Override
    public List<GrouponRules> grouponList(Integer goodsId) {
        return grouponRulesMapper.grouponList(goodsId);
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
}
