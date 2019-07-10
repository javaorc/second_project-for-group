package com.cskaoyan.service.userManegeService;


import com.cskaoyan.bean.Footprint;
import com.cskaoyan.mapper.userManege.FootprintMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootprintServiceImpl implements FootprintService {
    @Autowired
    FootprintMapper footprintMapper;
    @Override
    public List<Footprint> queryFootprint() {
        List<Footprint> footprints = footprintMapper.queryFootprint();
        return footprints;
    }
}
