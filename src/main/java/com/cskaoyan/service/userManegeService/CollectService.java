package com.cskaoyan.service.userManegeService;

import com.cskaoyan.bean.Collect;

import java.util.List;

public interface CollectService {


    List<Collect> queryCollect();
    List<Collect> queryCollectByUserIdAndValueID(Integer userId, Integer valueId);
}
