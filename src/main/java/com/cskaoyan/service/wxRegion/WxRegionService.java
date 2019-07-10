package com.cskaoyan.service.wxRegion;

import com.cskaoyan.bean.Region;

import java.util.List;

public interface WxRegionService {
    List<Region> queryRegionListByPid(int pid);
}
