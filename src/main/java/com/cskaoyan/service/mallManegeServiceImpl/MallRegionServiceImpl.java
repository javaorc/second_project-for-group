package com.cskaoyan.service.mallManegeServiceImpl;

import com.cskaoyan.service.MallRegionService;

import com.cskaoyan.bean.Region;

import com.cskaoyan.bean.Province;
import com.cskaoyan.mapper.mallManege.MallRegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MallRegionServiceImpl implements MallRegionService {
    @Autowired(required = false)
    MallRegionMapper mallRegionMapper;



    @Override
    public List<Province> showArea() {
        return mallRegionMapper.showArea();
    }
}
