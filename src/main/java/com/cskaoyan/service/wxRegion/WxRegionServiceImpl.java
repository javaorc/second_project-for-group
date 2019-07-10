package com.cskaoyan.service.wxRegion;

import com.cskaoyan.bean.Region;
import com.cskaoyan.mapper.wxRegion.WxRegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxRegionServiceImpl implements WxRegionService {

    @Autowired
    WxRegionMapper regionMapper;

    @Override
    public List<Region> queryRegionListByPid(int pid) {
        return regionMapper.queryRegionListByPid(pid);
    }
}
