package com.cskaoyan.mapper.wxRegion;

import com.cskaoyan.bean.Region;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxRegionMapper {

    List<Region> queryRegionListByPid(@Param("pid") int pid);
}
