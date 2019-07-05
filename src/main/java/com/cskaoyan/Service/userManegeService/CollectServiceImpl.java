package com.cskaoyan.Service.userManegeService;

import com.cskaoyan.bean.Collect;
import com.cskaoyan.bean.User;
import com.cskaoyan.mapper.userManege.CollectMapper;
import com.cskaoyan.mapper.userManege.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    CollectMapper collectMapper;

    @Override
    public List<Collect> queryCollect() {
        List<Collect> collects = collectMapper.queryCollect();
        return collects;
    }

    @Override
    public List<Collect> queryCollectByUserIdAndValueID(Integer userId, Integer valueId) {
        List<Collect> collects = collectMapper.queryCollectByUserIdAndValueID(userId, valueId);
        return collects;
    }
}
