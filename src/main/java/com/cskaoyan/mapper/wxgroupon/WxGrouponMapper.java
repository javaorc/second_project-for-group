package com.cskaoyan.mapper.wxgroupon;

import com.cskaoyan.bean.Feedback;
import com.cskaoyan.bean.GrouponRules;
import com.cskaoyan.bean.wxgrouponrela.GrouponDetail;
import com.cskaoyan.bean.wxgrouponrela.GrouponMy;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/8 15:47
 **/
public interface WxGrouponMapper {
    List<GrouponRules> gouponList();

    List<GrouponMy> grouponMy(@Param("showType") Integer showType);

    GrouponDetail queryGrouponDetailByGrouponId(@Param("grouponId") Integer grouponId);

    int feedback(@Param("feedback") Feedback feedback);
}
