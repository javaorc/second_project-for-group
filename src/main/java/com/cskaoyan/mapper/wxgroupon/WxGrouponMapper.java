package com.cskaoyan.mapper.wxgroupon;

import com.cskaoyan.bean.GrouponRules;
import com.cskaoyan.bean.wxgrouponrela.GrouponMy;

import java.util.List;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/8 15:47
 **/
public interface WxGrouponMapper {
    List<GrouponRules> gouponList();

    List<GrouponMy> grouponMy(Integer showType);
}
