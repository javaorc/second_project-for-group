package com.cskaoyan.Service.userManegeService;

import com.cskaoyan.bean.Collect;
import com.cskaoyan.bean.User;

import java.util.List;

public interface CollectService {


    List<Collect> queryCollect();
    List<Collect> queryCollectByUserIdAndValueID(Integer userId, Integer valueId);
}
