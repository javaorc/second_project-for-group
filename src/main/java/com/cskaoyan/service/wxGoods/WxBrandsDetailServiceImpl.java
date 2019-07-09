package com.cskaoyan.service.wxGoods;

import com.cskaoyan.bean.Brand;
import com.cskaoyan.mapper.wxGoods.WxBrandsDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WxBrandsDetailServiceImpl implements WxBrandsDetailService {

    @Autowired
    WxBrandsDetailMapper brandsDetailMapper;

    @Override
    public Brand queryBrandsDetailById(int id) {
        Brand brand = brandsDetailMapper.queryBrandsDetailById(id);
        return brand;
    }
}
