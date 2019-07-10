package com.cskaoyan.service.wxCollectZLX;

import com.cskaoyan.bean.Collect;
import com.cskaoyan.mapper.wxCollectZLX.WxCollectZLXMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
