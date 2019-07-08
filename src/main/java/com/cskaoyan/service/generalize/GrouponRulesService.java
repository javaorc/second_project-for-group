package com.cskaoyan.service.generalize;

import com.cskaoyan.bean.Groupon;
import com.cskaoyan.bean.GrouponRules;
import com.cskaoyan.bean.vo.ResponseVO;

import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/5 15:55
 **/
public interface GrouponRulesService {
    ResponseVO<Map<String, Object>> grouponList(Integer goodsId,int page,int limit);

    int updateGrouponRules(GrouponRules grouponRules);

    int deleteGrouponRules(GrouponRules grouponRules);

    int insertGrouponRules(GrouponRules grouponRules);

    List<Groupon> queryGrouponAndRulesAndGoods(Integer goodsId);
}
