package com.cskaoyan.service.wxCollectZLX;

import com.cskaoyan.bean.Collect;
import com.cskaoyan.mapper.wxCollectZLX.WxCollectZLXMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class WxCollectZLXServiceImpl implements WxCollectZLXService {
    @Autowired
    WxCollectZLXMapper collectZLXMapper;

    @Override
    public List<Collect> queryCollectByUserId(int userId) {
        List<Collect> collects = collectZLXMapper.queryCollect(userId);
        return collects;
    }

    @Override
    public Collect queryCollectByGoodsId(int userId, int goodsId) {
        Collect collect = collectZLXMapper.queryCollectByGoodsId(userId, goodsId);
        return collect;
    }

    @Override
    public void addCollectByGoodsId(int userId, int goodsId) {
        Collect collect = new Collect();
        Date addTime = new Date();
        collect.setAddTime(addTime);
        collect.setUpdateTime(addTime);
        collect.setDeleted(false);
        collect.setType((byte) 1);
        collect.setUserId(userId);
        collect.setValueId(goodsId);
        collectZLXMapper.addCollect(collect);
    }

    @Override
    public void updateDeletedFalse(int collectId) {
        collectZLXMapper.updateDeletedFalse(collectId,new Date());
    }

/*    @Override
    public void updateDeletedTrue(int collectId) {
        collectZLXMapper.updateDeletedTrue(collectId,new Date());
    }*/
}
