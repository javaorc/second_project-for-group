package com.cskaoyan.mapper.userManege;

import com.cskaoyan.bean.Collect;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectMapper {



    List<Collect> queryCollect();
    List<Collect> queryCollectByUserIdAndValueID(@Param("userId") Integer userId, @Param("valueId") Integer valueId);
}
