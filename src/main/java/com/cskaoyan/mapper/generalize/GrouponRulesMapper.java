package com.cskaoyan.mapper.generalize;

import com.cskaoyan.bean.Groupon;
import com.cskaoyan.bean.GrouponRules;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/5 16:00
 **/
public interface GrouponRulesMapper {
    List<GrouponRules> grouponList(@Param("goodsId") Integer goodsId);

    int updateGrouponRules(@Param("grules") GrouponRules grouponRules);

    int deleteGrouponRules(@Param("grules") GrouponRules grouponRules);

    int insertGrouponRules(@Param("grules") GrouponRules grouponRules);

    List<Groupon> queryGrouponAndRulesAndGoods(@Param("goodsId") Integer goodsId);
}
