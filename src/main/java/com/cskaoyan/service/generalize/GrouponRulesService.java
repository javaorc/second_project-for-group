package com.cskaoyan.service.generalize;

import com.cskaoyan.bean.Groupon;
import com.cskaoyan.bean.GrouponRules;

import java.util.List;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/5 15:55
 **/
public interface GrouponRulesService {
    List<GrouponRules> grouponList(Integer goodsId);

    int updateGrouponRules(GrouponRules grouponRules);

    int deleteGrouponRules(GrouponRules grouponRules);

    int insertGrouponRules(GrouponRules grouponRules);

    List<Groupon> queryGrouponAndRulesAndGoods(Integer goodsId);
}
