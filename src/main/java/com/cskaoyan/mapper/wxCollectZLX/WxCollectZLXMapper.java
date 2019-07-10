package com.cskaoyan.mapper.wxCollectZLX;

import com.cskaoyan.bean.Collect;
import com.cskaoyan.bean.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface WxCollectZLXMapper {

    List<Collect> queryCollect(@Param("userId")int userId);
    Collect queryCollectByGoodsId(@Param("userId")int userId,@Param("goodsId")int goodsId);
    void updateDeletedFalse(@Param("collectId")int collectId, @Param("updateDate")Date updateDate);
/*    void updateDeletedTrue(@Param("collectId")int collectId, @Param("updateDate")Date updateDate);*/
    void addCollect(@Param("collect")Collect collect);
}
