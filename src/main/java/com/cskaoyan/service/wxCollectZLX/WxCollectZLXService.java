package com.cskaoyan.service.wxCollectZLX;

import com.cskaoyan.bean.Collect;

import java.util.List;

public interface WxCollectZLXService {

    List<Collect> queryCollectByUserId(int userId);
    Collect queryCollectByGoodsId(int userId,int goodsId);
    void addCollectByGoodsId(int userId,int goodsId);
    void updateDeletedFalse(int collectId);

}
